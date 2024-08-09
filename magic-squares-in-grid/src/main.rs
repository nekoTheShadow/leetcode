use std::collections::HashSet;

impl Solution {
    pub fn num_magic_squares_inside(grid: Vec<Vec<i32>>) -> i32 {
        let h = grid.len();
        let w = grid[0].len();
        if h < 3 || w < 3 {
            return 0;
        }

        let mut ret = 0;
        for x in 0..=h - 3 {
            for y in 0..=w - 3 {
                if Self::check(&grid, x, y) {
                    ret += 1;
                }
            }
        }

        ret
    }

    pub fn check(grid: &Vec<Vec<i32>>, x: usize, y: usize) -> bool {
        let mut set = HashSet::new();
        for i in x..x + 3 {
            for j in y..y + 3 {
                let v = grid[i][j];
                if !(1 <= v && v <= 9 && !set.contains(&v)) {
                    return false;
                }
                set.insert(v);
            }
        }

        for i in x..x + 3 {
            if (y..y + 3).map(|j| grid[i][j]).sum::<i32>() != 15 {
                return false;
            }
        }
        for j in y..y + 3 {
            if (x..x + 3).map(|i| grid[i][j]).sum::<i32>() != 15 {
                return false;
            }
        }

        if grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2] != 15 {
            return false;
        }
        if grid[x + 2][y] + grid[x + 1][y + 1] + grid[x][y + 2] != 15 {
            return false;
        }

        return true;
    }
}struct Solution;

fn main() {
    println!(
        "{}",
        Solution::num_magic_squares_inside(
            [[4, 3, 8, 4], [9, 5, 1, 9], [2, 7, 6, 2]]
                .map(|v| v.to_vec())
                .to_vec()
        )
    );

    println!("{}", Solution::num_magic_squares_inside(vec![vec![8]]));
}
