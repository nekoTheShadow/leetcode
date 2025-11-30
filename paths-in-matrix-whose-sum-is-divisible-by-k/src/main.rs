use std::collections::HashMap;

impl Solution {
    pub fn number_of_paths(grid: Vec<Vec<i32>>, k: i32) -> i32 {
        f(&grid, k, &mut HashMap::new(), 0, 0, 0)
    }
}

fn f(
    grid: &Vec<Vec<i32>>,
    k: i32,
    memo: &mut HashMap<(usize, usize, i32), i32>,
    x: usize,
    y: usize,
    total: i32,
) -> i32 {
    let h = grid.len();
    let w = grid[0].len();

    let new_total = (total + grid[x][y]) % k;
    if x == h - 1 && y == w - 1 {
        if new_total == 0 {
            return 1;
        } else {
            return 0;
        }
    }

    let key = (x, y, total);
    if let Some(v) = memo.get(&key) {
        return *v;
    }

    let mut ret = 0;
    for (dx, dy) in [(1, 0), (0, 1)] {
        let nx = x + dx;
        let ny = y + dy;
        if nx < h && ny < w {
            ret += f(grid, k, memo, nx, ny, new_total);
            ret %= 1_000_000_000 + 7;
        }
    }
    memo.insert(key, ret);
    ret
}

struct Solution;

fn main() {
    let grid = [[5, 2, 4], [3, 0, 5], [0, 7, 2]];
    let k = 3;
    let output = 2;
    assert_eq!(
        Solution::number_of_paths(grid.map(|row| row.to_vec()).to_vec(), k),
        output
    );
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        let grid = [[5, 2, 4], [3, 0, 5], [0, 7, 2]];
        let k = 3;
        let output = 2;
        assert_eq!(
            Solution::number_of_paths(grid.map(|row| row.to_vec()).to_vec(), k),
            output
        );
    }

    #[test]
    fn example2() {
        let grid = [[0,0]];
        let k = 5;
        let output = 1;
        assert_eq!(
            Solution::number_of_paths(grid.map(|row| row.to_vec()).to_vec(), k),
            output
        );
    }

        #[test]
    fn example3() {
        let grid = [[7,3,4,9],[2,3,6,2],[2,3,7,0]];
        let k = 1;
        let output = 10;
        assert_eq!(
            Solution::number_of_paths(grid.map(|row| row.to_vec()).to_vec(), k),
            output
        );
    }
}
