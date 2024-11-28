use std::{collections::VecDeque, i32};

pub const INF: i32 = i32::MAX / 2 - 1;

impl Solution {
    pub fn minimum_obstacles(grid: Vec<Vec<i32>>) -> i32 {
        let h = grid.len() as i32;
        let w = grid[0].len() as i32;

        let mut dist = vec![vec![INF; w as usize]; h as usize];
        dist[0][0] = 0;

        let mut dq = VecDeque::new();
        dq.push_back((0, 0));

        while let Some((x, y)) = dq.pop_front() {
            for (dx, dy) in [(0, 1), (0, -1), (1, 0), (-1, 0)] {
                let nx = x + dx;
                let ny = y + dy;

                if 0 <= nx && nx < h && 0 <= ny && ny < w {
                    let cost = grid[nx as usize][ny as usize];
                    if dist[x as usize][y as usize] + cost < dist[nx as usize][ny as usize] {
                        dist[nx as usize][ny as usize] = dist[x as usize][y as usize] + cost;
                        if cost == 0 {
                            dq.push_front((nx, ny));
                        } else {
                            dq.push_back((nx, ny));
                        }
                    }
                }
            }
        }

        dist[(h - 1) as usize][(w - 1) as usize]
    }
}

struct Solution;

fn main() {
    assert_eq!(
        2,
        Solution::minimum_obstacles(
            [[0, 1, 1], [1, 1, 0], [1, 1, 0]]
                .map(|a| a.to_vec())
                .to_vec()
        )
    );
    assert_eq!(
        0,
        Solution::minimum_obstacles(
            [[0, 1, 0, 0, 0], [0, 1, 0, 1, 0], [0, 0, 0, 1, 0]]
                .map(|a| a.to_vec())
                .to_vec()
        )
    )
}
