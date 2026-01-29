use std::{cmp::Reverse, collections::BinaryHeap};

const INF: i32 = 1_000_000_007;

impl Solution {
    pub fn min_cost(n: i32, edges: Vec<Vec<i32>>) -> i32 {
        let n = n as usize;

        let mut g = vec![vec![]; n];
        for edge in edges {
            let u = edge[0] as usize;
            let v = edge[1] as usize;
            let w = edge[2];
            g[u].push((v, w));
            g[v].push((u, w * 2));
        }

        let mut d = vec![INF; n];
        d[0] = 0;

        let mut pq = BinaryHeap::new();
        pq.push((Reverse(0), 0));
        while let Some((Reverse(cost), cur)) = pq.pop() {
            if d[cur] < cost {
                continue;
            }
            for &(nxt, w) in &g[cur] {        
                if d[cur] + w < d[nxt] {
                    d[nxt] = d[cur] + w;
                    pq.push((Reverse(d[cur] + w), nxt));
                }
            }
        }

        let ans = d[n-1];
        if ans == INF { -1 } else { ans }
    }
}

struct Solution;

fn main() {
    let n = 3;
    let edges = [[2, 1, 1], [1, 0, 1], [2, 0, 16]];
    println!(
        "{}",
        Solution::min_cost(n, edges.map(|edge| edge.to_vec()).to_vec())
    );
}

#[cfg(test)]
mod test {
    use crate::Solution;

    #[test]
    fn example1() {
        let n = 4;
        let edges = [[0, 1, 3], [3, 1, 1], [2, 3, 4], [0, 2, 2]];
        let output = 5;
        assert_eq!(
            Solution::min_cost(n, edges.map(|edge| edge.to_vec()).to_vec()),
            output
        );
    }

    #[test]
    fn example2() {
        let n = 4;
        let edges = [[0, 2, 1], [2, 1, 1], [1, 3, 1], [2, 3, 3]];
        let output = 3;
        assert_eq!(
            Solution::min_cost(n, edges.map(|edge| edge.to_vec()).to_vec()),
            output
        );
    }
}
