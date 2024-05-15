use std::collections::{BinaryHeap, VecDeque};

impl Solution {
    pub fn maximum_safeness_factor(grid: Vec<Vec<i32>>) -> i32 {
        let n = grid.len() as i32;

        let mut safe = vec![vec![i32::MAX; n as usize]; n as usize];
        let mut q = VecDeque::new();
        for i in 0..n {
            for j in 0..n {
                if grid[i as usize][j as usize] == 1 {
                    safe[i as usize][j as usize] = 0;
                    q.push_back((i, j));
                }
            }
        }
        while let Some((i, j)) = q.pop_front() {
            for (di, dj) in [(1, 0), (-1, 0), (0, 1), (0, -1)] {
                let x = i + di;
                let y = j + dj;
                if 0 <= x
                    && x < n
                    && 0 <= y
                    && y < n
                    && safe[i as usize][j as usize] + 1 < safe[x as usize][y as usize]
                {
                    safe[x as usize][y as usize] = safe[i as usize][j as usize] + 1;
                    q.push_back((x, y));
                }
            }
        }

        let mut pq = BinaryHeap::new();
        let mut visited = vec![vec![-1; n as usize]; n as usize];
        pq.push((safe[0][0], 0_i32, 0_i32));
        visited[0][0] = safe[0][0];
        while let Some((s, i, j)) = pq.pop() {
            for (di, dj) in [(1, 0), (-1, 0), (0, 1), (0, -1)] {
                let x = i + di;
                let y = j + dj;
                if 0 <= x && x < n && 0 <= y && y < n && visited[x as usize][y as usize] == -1 {
                    visited[x as usize][y as usize] = s.min(safe[x as usize][y as usize]);
                    pq.push((visited[x as usize][y as usize], x, y));
                }
            }
        }
        visited[n as usize - 1][n as usize - 1]
    }
}

struct Solution;


fn main() {
    println!(
        "{}",
        Solution::maximum_safeness_factor(
            [[1, 0, 0], [0, 0, 0], [0, 0, 1]]
                .map(|a| a.to_vec())
                .to_vec()
        )
    );
    println!(
        "{}",
        Solution::maximum_safeness_factor(
            [[0, 0, 1], [0, 0, 0], [0, 0, 0]]
                .map(|a| a.to_vec())
                .to_vec()
        )
    );
    println!(
        "{}",
        Solution::maximum_safeness_factor(
            [[0, 0, 0, 1], [0, 0, 0, 0], [0, 0, 0, 0], [1, 0, 0, 0]]
                .map(|a| a.to_vec())
                .to_vec()
        )
    );
}
