use std::{cmp::max, collections::VecDeque, i32, usize};

impl Solution {
    pub fn most_profitable_path(edges: Vec<Vec<i32>>, bob: i32, amount: Vec<i32>) -> i32 {
        let n = edges.len() + 1;
        let bob = bob as usize;

        let mut g = vec![vec![]; n];
        for edge in edges {
            let a = edge[0] as usize;
            let b = edge[1] as usize;
            g[a].push(b);
            g[b].push(a);
        }

        let bob_path = create_bob_path(&g, bob);
        let mut max_amount = i32::MIN;
        dfs(&g, &amount, &bob_path, usize::MAX, 0, 0, 0, &mut max_amount);
        max_amount
    }
}

fn create_bob_path(g: &Vec<Vec<usize>>, bob: usize) -> Vec<usize> {
    let mut q = VecDeque::new();
    let mut costs = vec![usize::MAX; g.len()];
    let mut pre = vec![usize::MAX; g.len()];
    q.push_back(bob);
    costs[bob] = 0;

    while let Some(cur) = q.pop_front() {
        for &nxt in &g[cur] {
            if costs[cur] + 1 < costs[nxt] {
                costs[nxt] = costs[cur] + 1;
                q.push_back(nxt);
                pre[nxt] = cur;
            }
        }
    }

    let mut path = vec![];
    let mut cur = 0;
    while cur != bob {
        path.push(cur);
        cur = pre[cur];
    }

    path.push(bob);
    path.reverse();
    path
}

fn dfs(
    g: &Vec<Vec<usize>>,
    amounts: &Vec<i32>,
    bob_path: &Vec<usize>,
    pre: usize,
    cur: usize,
    time: usize,
    amount: i32,
    max_amount: &mut i32,
) {
    let new_amount = if let Some(bob_time) = bob_path.iter().position(|&bob_place| bob_place == cur)
    {
        if time < bob_time {
            amount + amounts[cur]
        } else if time == bob_time {
            amount + amounts[cur] / 2
        } else {
            amount
        }
    } else {
        amount + amounts[cur]
    };

    let mut is_leaf = true;
    for &nxt in &g[cur] {
        if nxt == pre {
            continue;
        }
        is_leaf = false;
        dfs(
            g,
            amounts,
            bob_path,
            cur,
            nxt,
            time + 1,
            new_amount,
            max_amount,
        );
    }

    if is_leaf {
        *max_amount = max(*max_amount, new_amount);
    }
}
struct Solution;

fn main() {
    example1();
    example2();
}

fn example1() {
    let edges = [[0, 1], [1, 2], [1, 3], [3, 4]]
        .map(|edge| edge.to_vec())
        .to_vec();
    let bob = 3;
    let amount = [-2, 4, 2, -4, 6].to_vec();
    println!("{}", Solution::most_profitable_path(edges, bob, amount));
}

fn example2() {
    let edges = [[0, 1]].map(|edge| edge.to_vec()).to_vec();
    let bob = 1;
    let amount = [-7280, 2350].to_vec();
    println!("{}", Solution::most_profitable_path(edges, bob, amount));
}
