impl Solution {
    pub fn find_redundant_connection(edges: Vec<Vec<i32>>) -> Vec<i32> {
        let n = edges.len();
        let mut uf = UnionFind::new(n);
        for edge in edges {
            let x = (edge[0] - 1) as usize;
            let y = (edge[1] - 1) as usize;
            if uf.find(x) == uf.find(y) {
                return edge;
            }
            uf.union(x, y);
        }
        unreachable!()
    }
}

struct UnionFind {
    parent: Vec<usize>,
}

impl UnionFind {
    pub fn new(n: usize) -> Self {
        UnionFind {
            parent: (0..n).collect(),
        }
    }

    pub fn find(&mut self, x: usize) -> usize {
        if self.parent[x] == x {
            return x;
        }
        self.parent[x] = self.find(self.parent[x]);
        self.parent[x]
    }

    pub fn union(&mut self, x: usize, y: usize) {
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
    testing(&[[1, 2], [1, 3], [2, 3]], [2, 3]);
    testing(&[[1, 2], [2, 3], [3, 4], [1, 4], [1, 5]], [1, 4]);
}

fn testing(edges: &[[i32; 2]], expected: [i32; 2]) {
    let actual =
        Solution::find_redundant_connection(edges.iter().map(|edge| edge.to_vec()).collect());
    assert_eq!(expected.to_vec(), actual)
}
