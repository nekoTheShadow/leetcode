use std::collections::{HashMap, VecDeque};

impl Solution {
    pub fn magnificent_sets(n: i32, edges: Vec<Vec<i32>>) -> i32 {
        let n = n as usize;
        let mut g = vec![vec![]; n];
        for edge in edges {
            let a = (edge[0] - 1) as usize;
            let b = (edge[1] - 1) as usize;
            g[a].push(b);
            g[b].push(a);
        }

        // 二部グラフではないものがあった場合は処理終了
        for i in 0..n {
            if !dfs(&g, i, 0, &mut vec![2; n]) {
                return -1;
            }
        }

        let mut d = HashMap::new();
        for i in 0..n {
            let (group, max) = bfs(n, &g, i);
            d.entry(group)
                .and_modify(|v| *v = std::cmp::max(*v, max))
                .or_insert(max);
        }
        d.values().sum()
    }
}

//  0 : 白
//  1 : 黒
//  2 : 未確定
fn dfs(g: &Vec<Vec<usize>>, cur: usize, color: usize, colors: &mut Vec<usize>) -> bool {
    colors[cur] = color;
    for &nxt in &g[cur] {
        if colors[nxt] == 2 {
            if !dfs(g, nxt, 1 - color, colors) {
                return false;
            }
        } else {
            if colors[nxt] == color {
                return false;
            }
        }
    }
    true
}

fn bfs(n: usize, g: &Vec<Vec<usize>>, start: usize) -> (usize, i32) {
    let mut d = vec![-1; n];
    let mut q = VecDeque::new();
    q.push_back(start);
    d[start] = 1;

    while let Some(cur) = q.pop_front() {
        for &nxt in &g[cur] {
            if d[nxt] == -1 {
                d[nxt] = d[cur] + 1;
                q.push_back(nxt);
            }
        }
    }

    let group = (0..n).filter(|&i| d[i] != -1).nth(0).unwrap();
    let &max = d.iter().filter(|&&v| v != -1).max().unwrap();
    (group, max)
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::magnificent_sets(
            6,
            [[1, 2], [1, 4], [1, 5], [2, 6], [2, 3], [4, 6]]
                .map(|edge| edge.to_vec())
                .to_vec()
        ),
        4
    );
    assert_eq!(
        Solution::magnificent_sets(
            3,
            [[1, 2], [2, 3], [3, 1]].map(|edge| edge.to_vec()).to_vec()
        ),
        -1
    );
}
