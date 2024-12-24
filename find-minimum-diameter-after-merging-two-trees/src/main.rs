use std::collections::VecDeque;

impl Solution {
    pub fn minimum_diameter_after_merge(edges1: Vec<Vec<i32>>, edges2: Vec<Vec<i32>>) -> i32 {
        let g1 = to_graph(&edges1);
        let g2 = to_graph(&edges2);

        let d1 = find_diameter(&g1);
        let d2 = find_diameter(&g2);

        *[d1, d2, (d1 + 1) / 2 + (d2 + 1) / 2 + 1]
            .iter()
            .max()
            .unwrap()
    }
}

fn to_graph(edges: &Vec<Vec<i32>>) -> Vec<Vec<usize>> {
    let n = edges.len() + 1;
    let mut g = vec![vec![]; n];
    for edge in edges {
        let x = edge[0] as usize;
        let y = edge[1] as usize;
        g[x].push(y);
        g[y].push(x);
    }
    g
}

fn find_diameter(graph: &Vec<Vec<usize>>) -> i32 {
    let (x, _) = find_farest_node(graph, 0);
    let (_, diameter) = find_farest_node(graph, x);
    diameter
}

fn find_farest_node(graph: &Vec<Vec<usize>>, start: usize) -> (usize, i32) {
    let mut q = VecDeque::new();
    q.push_back(start);

    let n = graph.len();
    let mut distance = vec![i32::MAX; n];
    distance[start] = 0;

    while let Some(cur) = q.pop_front() {
        for &nxt in &graph[cur] {
            if distance[cur] + 1 < distance[nxt] {
                distance[nxt] = distance[cur] + 1;
                q.push_back(nxt);
            }
        }
    }

    let x = (0..n).max_by_key(|&i| distance[i]).unwrap();
    (x, distance[x])
}

struct Solution;

fn main() {
    check(&[[0, 1], [0, 2], [0, 3]], &[[0, 1]], 3);
    check(
        &[[0, 1], [0, 2], [0, 3], [2, 4], [2, 5], [3, 6], [2, 7]],
        &[[0, 1], [0, 2], [0, 3], [2, 4], [2, 5], [3, 6], [2, 7]],
        5,
    );
}

fn check(edges1: &[[i32; 2]], edges2: &[[i32; 2]], expected: i32) {
    assert_eq!(
        Solution::minimum_diameter_after_merge(
            edges1.iter().map(|e| e.to_vec()).collect(),
            edges2.iter().map(|e| e.to_vec()).collect()
        ),
        expected
    );
}
