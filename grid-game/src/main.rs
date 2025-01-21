impl Solution {
    pub fn grid_game(grid: Vec<Vec<i32>>) -> i64 {
        let n = grid[0].len();
        let grid: Vec<Vec<i64>> = grid
            .iter()
            .map(|row| row.iter().map(|v| *v as i64).collect())
            .collect();

        let mut d0 = vec![0; n + 1];
        let mut d1 = vec![0; n + 1];
        for i in 0..n {
            d0[i + 1] = d0[i] + grid[0][i];
            d1[i + 1] = d1[i] + grid[1][i];
        }

        (0..n)
            .map(|i| {
                let sum0 = d0[n] - d0[i + 1]; // grid[0][i+1..]
                let sum1 = d1[i] - d1[0]; // grid[1][..i]
                std::cmp::max(sum0, sum1)
            })
            .min()
            .unwrap()
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::grid_game([[2, 5, 4], [1, 5, 1]].map(|a| a.to_vec()).to_vec())
    );
    println!(
        "{}",
        Solution::grid_game([[3, 3, 1], [8, 5, 2]].map(|a| a.to_vec()).to_vec())
    );
    println!(
        "{}",
        Solution::grid_game([[1, 3, 1, 15], [1, 3, 3, 1]].map(|a| a.to_vec()).to_vec())
    );
    println!(
        "{}",
        Solution::grid_game(
            [
                [20, 3, 20, 17, 2, 12, 15, 17, 4, 15],
                [20, 10, 13, 14, 15, 5, 2, 3, 14, 3]
            ]
            .map(|a| a.to_vec())
            .to_vec()
        )
    );
}
