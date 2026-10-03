use std::collections::HashMap;

impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<char>>) -> bool {
        dfs(&mut HashMap::new(), &grid, 0, 0, 0)
    }
}

fn dfs(
    memo: &mut HashMap<(usize, usize, usize), bool>,
    grid: &Vec<Vec<char>>,
    row: usize,
    col: usize,
    balance: usize,
) -> bool {
    let h = grid.len();
    let w = grid[0].len();

    if h <= row || w <= col {
        return false;
    }

    let key = (row, col, balance);
    if memo.contains_key(&key) {
        return memo[&key];
    }

    let mut next_balance = balance;
    if grid[row][col] == '(' {
        next_balance += 1;
    } else {
        if next_balance == 0 {
            return false;
        }
        next_balance -= 1;
    }

    if row == h - 1 && col == w - 1 {
        return next_balance == 0;
    }

    let ok =
        dfs(memo, grid, row + 1, col, next_balance) || dfs(memo, grid, row, col + 1, next_balance);
    memo.insert(key, ok);
    ok
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use std::assert_eq;

    use crate::Solution;

    #[test]
    fn example1() {
        let grid = [
            ["(", "(", "("],
            [")", "(", ")"],
            ["(", "(", ")"],
            ["(", "(", ")"],
        ];
        assert_eq!(
            Solution::has_valid_path(
                grid.map(|row| row.map(|cell| cell.chars().next().unwrap()).to_vec())
                    .to_vec()
            ),
            true
        )
    }
    #[test]
    fn example2() {
        let grid = [[")", ")"], ["(", "("]];
        assert_eq!(
            Solution::has_valid_path(
                grid.map(|row| row.map(|cell| cell.chars().next().unwrap()).to_vec())
                    .to_vec()
            ),
            false
        )
    }
}
