use std::collections::HashMap;

impl Solution {
    pub fn minimum_cost(n: i32, edges: Vec<Vec<i32>>, query: Vec<Vec<i32>>) -> Vec<i32> {
        let n = n as usize;
        let mut uf = UnionFind::new(n);

        for edge in &edges {
            let (u, v, _w) = expand_edge(edge);
            uf.union(u, v);
        }

        let mut cost = HashMap::new();
        for edge in &edges {
            let (u, _v, w) = expand_edge(edge);
            cost.entry(uf.find(u)).and_modify(|d| *d &= w).or_insert(w);
        }

        query
            .iter()
            .map(|q| {
                let (s, t) = expand_query(q);
                let s = uf.find(s);
                let t = uf.find(t);
                if s == t {
                    cost[&s]
                } else {
                    -1
                }
            })
            .collect()
    }
}

fn expand_edge(edge: &Vec<i32>) -> (usize, usize, i32) {
    (edge[0] as usize, edge[1] as usize, edge[2])
}

fn expand_query(q: &Vec<i32>) -> (usize, usize) {
    (q[0] as usize, q[1] as usize)
}

struct UnionFind {
    parent: Vec<usize>,
}

impl UnionFind {
    fn new(n: usize) -> Self {
        Self {
            parent: (0..n).into_iter().collect(),
        }
    }

    fn find(&mut self, x: usize) -> usize {
        if self.parent[x] == x {
            return x;
        }
        self.parent[x] = self.find(self.parent[x]);
        self.parent[x]
    }

    fn union(&mut self, x: usize, y: usize) {
        let x = self.find(x);
        let y = self.find(y);
        if x == y {
            return;
        }
        self.parent[x] = y;
    }
}

struct Solution;

fn main() {
    testing(
        5,
        &[[0, 1, 7], [1, 3, 7], [1, 2, 1]],
        &[[0, 3], [3, 4]],
        &[1, -1],
    );
    testing(
        3,
        &[[0, 2, 7], [0, 1, 15], [1, 2, 6], [1, 2, 1]],
        &[[1, 2]],
        &[0],
    );
}

fn testing(n: i32, edges: &[[i32; 3]], query: &[[i32; 2]], expected: &[i32]) {
    let actual = Solution::minimum_cost(
        n,
        edges.iter().map(|edge| edge.to_vec()).collect(),
        query.iter().map(|q| q.to_vec()).collect(),
    );
    assert_eq!(actual, Vec::from(expected));
}
