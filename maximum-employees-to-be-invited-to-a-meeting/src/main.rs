use std::{cmp::max, collections::VecDeque};

impl Solution {
    pub fn maximum_invitations(favorite: Vec<i32>) -> i32 {
        let favorites = favorite.iter().map(|f| *f as usize).collect::<Vec<_>>();
        let n = favorites.len();

        let mut d = vec![0; n];
        let mut c = vec![0; n];
        let mut visited = vec![false; n];
        let mut q = VecDeque::new();

        for &favorite in &favorites {
            d[favorite as usize] += 1;
        }
        for i in 0..n {
            if d[i] == 0 {
                q.push_back(i);
            }
        }

        while let Some(u) = q.pop_front() {
            visited[u] = true;
            let v = favorites[u];
            c[v] = max(c[v], c[u] + 1);
            d[v] -= 1;
            if d[v] == 0 {
                q.push_back(v);
            }
        }

        let mut pair_chains = 0;
        let mut max_cycle = 0;
        for i in 0..n {
            if visited[i] {
                continue;
            }

            let mut cycle_len = 0;
            let mut current = i;
            while !visited[current] {
                visited[current] = true;
                current = favorites[current];
                cycle_len += 1;
            }

            if cycle_len == 2 {
                pair_chains += 2 + c[i] + c[favorites[i]];
            } else {
                max_cycle = max(max_cycle, cycle_len);
            }
        }

        max(max_cycle, pair_chains)
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::maximum_invitations(vec![2, 2, 1, 2]), 3);
    assert_eq!(Solution::maximum_invitations(vec![1, 2, 0]), 3);
    assert_eq!(Solution::maximum_invitations(vec![3, 0, 1, 4, 1]), 4);
}
