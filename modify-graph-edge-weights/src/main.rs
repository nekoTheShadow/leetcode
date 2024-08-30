use std::{cmp::Reverse, collections::BinaryHeap};

impl Solution {
    pub fn modified_graph_edges(
        n: i32,
        edges: Vec<Vec<i32>>,
        source: i32,
        destination: i32,
        target: i32,
    ) -> Vec<Vec<i32>> {
        let n = n as usize;
        let mut edges = edges;
        let source = source as usize;
        let destination = destination as usize;

        let a = Self::dijkstra(n, &edges, source, destination);
        if a < target {
            return Vec::new();
        }

        let mut m = a == target;
        let inf = i32::MAX / 2 - 1;

        for i in 0..edges.len() {
            if edges[i][2] > 0 {
                continue;
            }
            edges[i][2] = if m { inf } else { 1 };
            if !m {
                let b = Self::dijkstra(n, &edges, source, destination);
                if b <= target {
                    m = true;
                    edges[i][2] += target - b;
                }
            }
        }

        if m {
            edges
        } else {
            Vec::new()
        }
    }

    pub fn dijkstra(n: usize, edges: &Vec<Vec<i32>>, source: usize, destination: usize) -> i32 {
        let mut dist = vec![i32::MAX; n];
        dist[source] = 0;

        let mut g = vec![vec![]; n];
        for edge in edges {
            let x = edge[0] as usize;
            let y = edge[1] as usize;
            let w = edge[2];
            if w != -1 {
                g[x].push((y, w));
                g[y].push((x, w));
            }
        }

        let mut pq = BinaryHeap::new();
        pq.push((Reverse(dist[source]), source));
        while let Some((Reverse(d), cur)) = pq.pop() {
            if dist[cur] < d {
                continue;
            }
            for &(nxt, w) in &g[cur] {
                if dist[cur] + w < dist[nxt] {
                    dist[nxt] = dist[cur] + w;
                    pq.push((Reverse(dist[nxt]), nxt));
                }
            }
        }
        dist[destination]
    }
}

struct Solution;

fn main() {
    example01();
    example02();
    example03();
}

fn example03() {
    let n = 4;
    let edges = [[1, 0, 4], [1, 2, 3], [2, 3, 5], [0, 3, -1]]
        .map(|a| a.to_vec())
        .to_vec();
    let source = 0;
    let destination = 2;
    let target = 6;
    println!(
        "{:?}",
        Solution::modified_graph_edges(n, edges, source, destination, target)
    );
}

fn example01() {
    let n = 5;
    let edges = [[4, 1, -1], [2, 0, -1], [0, 3, -1], [4, 3, -1]]
        .map(|a| a.to_vec())
        .to_vec();
    let source = 0;
    let destination = 1;
    let target = 5;
    println!(
        "{:?}",
        Solution::modified_graph_edges(n, edges, source, destination, target)
    );
}

fn example02() {
    let n = 3;
    let edges = [[0, 1, -1], [0, 2, 5]].map(|a| a.to_vec()).to_vec();
    let source = 0;
    let destination = 2;
    let target = 6;
    println!(
        "{:?}",
        Solution::modified_graph_edges(n, edges, source, destination, target)
    );
}
