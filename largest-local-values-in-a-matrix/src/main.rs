impl Solution {
    pub fn largest_local(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let n = grid.len();
        let mut max_local = vec![vec![0; n - 2]; n - 2];
        for i in 0..n - 2 {
            for j in 0..n - 2 {
                for dx in 0..=2 {
                    for dy in 0..=2 {
                        max_local[i][j] = max_local[i][j].max(grid[i + dx][j + dy])
                    }
                }
            }
        }
        max_local
    }
}
pub struct Solution;

fn main() {
    println!(
        "{:?}",
        Solution::largest_local(
            [[9, 9, 8, 1], [5, 6, 2, 6], [8, 2, 6, 4], [6, 2, 2, 2]]
                .map(|v| v.to_vec())
                .to_vec()
        )
    );
    println!(
        "{:?}",
        Solution::largest_local(
            [
                [1, 1, 1, 1, 1],
                [1, 1, 1, 1, 1],
                [1, 1, 2, 1, 1],
                [1, 1, 1, 1, 1],
                [1, 1, 1, 1, 1]
            ]
            .map(|v| v.to_vec())
            .to_vec()
        )
    );
}
