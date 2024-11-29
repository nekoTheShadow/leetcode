use std::{
    cmp::{max, Reverse},
    collections::BinaryHeap,
};

impl Solution {
    pub fn minimum_time(grid: Vec<Vec<i32>>) -> i32 {
        if grid[0][1] > 1 && grid[1][0] > 1 {
            return -1;
        }

        let h = grid.len() as i32;
        let w = grid[0].len() as i32;

        let mut visited = vec![vec![false; w as usize]; h as usize];
        let mut pq = BinaryHeap::new();
        pq.push((Reverse(0), 0_i32, 0_i32));

        while let Some((Reverse(t), x, y)) = pq.pop() {
            if x == h - 1 && y == w - 1 {
                return t;
            }
            if at!(visited, x, y) {
                continue;
            }
            at!(visited, x, y) = true;

            for (dx, dy) in [(0, 1), (0, -1), (1, 0), (-1, 0)] {
                let nx = x + dx;
                let ny = y + dy;
                if 0 <= nx && nx < h && 0 <= ny && ny < w && !at!(visited, nx, ny) {
                    let wait = if (at!(grid, nx, ny) - t) % 2 == 0 {
                        1
                    } else {
                        0
                    };
                    let nt = max(t + 1, at!(grid, nx, ny) + wait);
                    pq.push((Reverse(nt), nx, ny));
                }
            }
        }
        return -1;
    }
}

#[macro_export]
macro_rules! at {
    ($m:expr,$x:expr,$y:expr) => {
        $m[$x as usize][$y as usize]
    };
}

struct Solution;

fn main() {
    assert_eq!(
        7,
        Solution::minimum_time(
            [[0, 1, 3, 2], [5, 1, 2, 5], [4, 3, 8, 6]]
                .map(|a| a.to_vec())
                .to_vec()
        )
    );
    assert_eq!(
        -1,
        Solution::minimum_time(
            [[0, 2, 4], [3, 2, 1], [1, 0, 4]]
                .map(|a| a.to_vec())
                .to_vec()
        )
    );
}
