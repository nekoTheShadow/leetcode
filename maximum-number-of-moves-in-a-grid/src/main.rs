use std::collections::VecDeque;

impl Solution {
    pub fn max_moves(grid: Vec<Vec<i32>>) -> i32 {
        (0..grid.len())
            .map(|x| Solution::solve(&grid, x as i32, 0))
            .max()
            .unwrap()
    }

    pub fn solve(grid: &Vec<Vec<i32>>, start_x: i32, start_y: i32) -> i32 {
        let m = grid.len() as i32;
        let n = grid[0].len() as i32;

        let mut count = vec![vec![-1; n as usize]; m as usize];
        count[start_x as usize][start_y as usize] = 0;

        let mut stack = VecDeque::new();
        stack.push_back((start_x, start_y));
        while let Some((x1, y1)) = stack.pop_back() {
            for (x2, y2) in [(x1 - 1, y1 + 1), (x1, y1 + 1), (x1 + 1, y1 + 1)] {
                if 0 <= x2
                    && x2 < m
                    && 0 <= y2
                    && y2 < n
                    && grid[x1 as usize][y1 as usize] < grid[x2 as usize][y2 as usize]
                    && count[x1 as usize][y1 as usize] + 1 > count[x2 as usize][y2 as usize]
                {
                    count[x2 as usize][y2 as usize] = count[x1 as usize][y1 as usize] + 1;
                    stack.push_back((x2, y2));
                }
            }
        }

        *count.iter().flat_map(|row| row.iter()).max().unwrap()
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::max_moves(
            [[2, 4, 3, 5], [5, 4, 9, 3], [3, 4, 2, 11], [10, 9, 13, 15]]
                .map(|a| a.to_vec())
                .to_vec()
        )
    );
    println!(
        "{}",
        Solution::max_moves(
            [[3, 2, 4], [2, 1, 9], [1, 1, 7]]
                .map(|a| a.to_vec())
                .to_vec()
        )
    );
}
