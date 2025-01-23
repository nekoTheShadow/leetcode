use std::collections::HashSet;

impl Solution {
    pub fn count_servers(grid: Vec<Vec<i32>>) -> i32 {
        let h = grid.len();
        let w = grid[0].len();

        let mut set = HashSet::new();
        for i in 0..h {
            let temp = (0..w)
                .filter_map(|j| get(&grid, i, j))
                .collect::<HashSet<_>>();
            if temp.len() >= 2 {
                set.extend(temp);
            }
        }
        for j in 0..w {
            let temp = (0..h)
                .filter_map(|i| get(&grid, i, j))
                .collect::<HashSet<_>>();
            if temp.len() >= 2 {
                set.extend(temp);
            }
        }

        set.len() as i32
    }
}

fn get(grid: &Vec<Vec<i32>>, i: usize, j: usize) -> Option<(usize, usize)> {
    if grid[i][j] == 1 {
        Some((i, j))
    } else {
        None
    }
}
struct Solution;

fn main() {
    testing!([[1, 0], [0, 1]], 0);
    testing!([[1, 0], [1, 1]], 3);
    testing!([[1, 1, 0, 0], [0, 0, 1, 0], [0, 0, 1, 0], [0, 0, 0, 1]], 4);
}

#[macro_export]
macro_rules! testing {
    ($grid:expr, $expected:expr) => {
        assert_eq!(
            $expected,
            Solution::count_servers($grid.map(|a| a.to_vec()).to_vec())
        );
    };
}
