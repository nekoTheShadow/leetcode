use std::collections::HashSet;

impl Solution {
    pub fn largest_island(grid: Vec<Vec<i32>>) -> i32 {
        let n = grid.len() as i32;

        let mut groups = vec![vec![-1; n as usize]; n as usize];
        let mut group = 0_i32;
        for i in 0..n {
            for j in 0..n {
                if get!(grid, i, j) == 0 || get!(groups, i, j) != -1 {
                    continue;
                }
                dfs(&grid, n, &mut groups, group, i, j);
                group += 1;
            }
        }

        let mut areas = vec![0; group as usize];
        for i in 0..n {
            for j in 0..n {
                if get!(grid, i, j) == 1 {
                    get!(areas, get!(groups, i, j)) += 1;
                }
            }
        }

        let mut max_area = *areas.iter().max().unwrap_or(&0);

        for cur_i in 0..n {
            for cur_j in 0..n {
                if get!(grid, cur_i, cur_j) == 1 {
                    continue;
                }

                let mut connected = HashSet::new();
                for (di, dj) in [(1, 0), (-1, 0), (0, 1), (0, -1)] {
                    let nxt_i = cur_i + di;
                    let nxt_j = cur_j + dj;
                    if range_check(n, nxt_i, nxt_j) && get!(grid, nxt_i, nxt_j) == 1 {
                        connected.insert(get!(groups, nxt_i, nxt_j));
                    }
                }
                let area = 1 + connected
                    .iter()
                    .map(|&group| get!(areas, group))
                    .sum::<i32>();
                max_area = std::cmp::max(max_area, area);
            }
        }

        max_area
    }
}

fn dfs(
    grid: &Vec<Vec<i32>>,
    n: i32,
    groups: &mut Vec<Vec<i32>>,
    group: i32,
    cur_i: i32,
    cur_j: i32,
) {
    get!(groups, cur_i, cur_j) = group;
    for (di, dj) in [(1, 0), (-1, 0), (0, 1), (0, -1)] {
        let nxt_i = cur_i + di;
        let nxt_j = cur_j + dj;
        if range_check(n, nxt_i, nxt_j)
            && get!(grid, nxt_i, nxt_j) == 1
            && get!(groups, nxt_i, nxt_j) == -1
        {
            dfs(grid, n, groups, group, nxt_i, nxt_j);
        }
    }
}

fn range_check(n: i32, x: i32, y: i32) -> bool {
    (0..n).contains(&x) && (0..n).contains(&y)
}

#[macro_export]
macro_rules! get {
    ($arr:expr, $x:expr) => {
        $arr[$x as usize]
    };
    ($mat:expr, $x:expr, $y:expr) => {
        $mat[$x as usize][$y as usize]
    };
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::largest_island([[1, 0], [0, 1]].map(|row| row.to_vec()).to_vec())
    );
    println!(
        "{}",
        Solution::largest_island([[1, 1], [1, 0]].map(|row| row.to_vec()).to_vec())
    );
    println!(
        "{}",
        Solution::largest_island([[1, 1], [1, 1]].map(|row| row.to_vec()).to_vec())
    );
}
