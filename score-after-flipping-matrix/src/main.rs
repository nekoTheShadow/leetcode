impl Solution {
    pub fn matrix_score(grid: Vec<Vec<i32>>) -> i32 {
        let mut grid = grid;
        let m = grid.len();
        let n = grid[0].len();

        for i in 0..m {
            if grid[i][0] == 0 {
                for j in 0..n {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        for j in 0..n {
            let c = (0..m).filter(|&i| grid[i][j] == 1).count();
            if c < m - c {
                for i in 0..m {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        let mut sum = 0;
        for row in grid {
            sum += row.iter().fold(0, |acc, &bit| (acc << 1) | bit)
        }
        sum
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::matrix_score(
            [[0, 0, 1, 1], [1, 0, 1, 0], [1, 1, 0, 0]]
                .map(|a| a.to_vec())
                .to_vec()
        )
    );
    println!(
        "{}",
        Solution::matrix_score([[0]].map(|a| a.to_vec()).to_vec())
    );
}
