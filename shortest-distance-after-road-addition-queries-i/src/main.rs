use std::collections::VecDeque;

impl Solution {
    pub fn shortest_distance_after_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
        let n = n as usize;
        let mut g = vec![vec![]; n];
        for i in 0..n - 1 {
            g[i].push(i + 1);
        }

        let mut ans = Vec::new();
        for query in queries {
            g[query[0] as usize].push(query[1] as usize);
            ans.push(Self::bfs(n, &g));
        }
        ans
    }

    pub fn bfs(n: usize, g: &Vec<Vec<usize>>) -> i32 {
        let mut cost = vec![Self::INF; n];
        let mut q = VecDeque::new();

        q.push_back((0, 0));
        cost[0] = 0;

        while let Some((x, c)) = q.pop_front() {
            if cost[x] < c {
                continue;
            }
            for &y in &g[x] {
                if cost[x] + 1 < cost[y] {
                    cost[y] = cost[x] + 1;
                    q.push_back((y, cost[y]));
                }
            }
        }

        cost[n - 1]
    }

    const INF: i32 = i32::MAX / 2 - 1;
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::shortest_distance_after_queries(
            5,
            [[2, 4], [0, 2], [0, 4]].map(|a| a.to_vec()).to_vec()
        ),
        vec![3, 2, 1]
    );
    assert_eq!(
        Solution::shortest_distance_after_queries(4, [[0, 3], [0, 2]].map(|a| a.to_vec()).to_vec()),
        vec![1, 1]
    );
}
