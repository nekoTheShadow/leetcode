use std::collections::{HashMap, HashSet};

impl Solution {
    pub fn count_complete_components(n: i32, edges: Vec<Vec<i32>>) -> i32 {
        let n = n as usize;

        let mut uf = UnionFind::new(n);
        for edge in &edges {
            let (a, b) = expand_edge(edge);
            uf.union(a, b);
        }

        let mut d1 = HashMap::new(); // count edge
        for edge in &edges {
            let (a, _b) = expand_edge(edge);
            *d1.entry(uf.find(a)).or_insert(0) += 1;
        }

        let mut d2 = HashMap::new(); // count point
        for i in 0..n {
            d2.entry(uf.find(i)).or_insert(HashSet::new()).insert(i);
        }

        d2.iter()
            .filter(|(root, set)| {
                let &c1 = d1.get(&root).unwrap_or(&0);
                let c2 = set.len();
                c1 == c2 * (c2 - 1) / 2
            })
            .count() as i32
    }
}

fn expand_edge(edge: &Vec<i32>) -> (usize, usize) {
    (edge[0] as usize, edge[1] as usize)
}

struct UnionFind {
    parent: Vec<usize>,
}

impl UnionFind {
    fn new(n: usize) -> Self {
        Self {
            parent: (0..n).into_iter().collect::<Vec<_>>(),
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
        if x != y {
            self.parent[x] = y;
        }
    }
}
struct Solution;

fn main() {
    testing(6, &[[0, 1], [0, 2], [1, 2], [3, 4]], 3);
    testing(6, &[[0, 1], [0, 2], [1, 2], [3, 4], [3, 5]], 1);
}

fn testing(n: i32, edges: &[[i32; 2]], expected: i32) {
    let actual =
        Solution::count_complete_components(n, edges.iter().map(|edge| edge.to_vec()).collect());
    assert_eq!(expected, actual);
}
