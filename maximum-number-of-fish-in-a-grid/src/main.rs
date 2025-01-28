impl Solution {
    pub fn find_max_fish(grid: Vec<Vec<i32>>) -> i32 {
        let h = grid.len() as i32;
        let w = grid[0].len() as i32;

        let mut visited = vec![vec![false; w as usize]; h as usize];
        let mut max_total = 0;
        for start_x in 0..h {
            for start_y in 0..w {
                // 陸のマス、すでに訪問済みのマスはスキップする
                if get!(grid, start_x, start_y) == 0 || get!(visited, start_x, start_y) {
                    continue;
                }

                let mut stack = vec![(start_x, start_y)];
                let mut total = 0;
                while let Some((current_x, current_y)) = stack.pop() {
                    if get!(visited, current_x, current_y) {
                        continue;
                    }

                    get!(visited, current_x, current_y) = true;
                    total += get!(grid, current_x, current_y);

                    for (dx, dy) in [(0, 1), (0, -1), (1, 0), (-1, 0)] {
                        let next_x = current_x + dx;
                        let next_y = current_y + dy;
                        if (0..h).contains(&next_x)
                            && (0..w).contains(&next_y)
                            && get!(grid, next_x, next_y) != 0
                        {
                            stack.push((next_x, next_y));
                        }
                    }
                }

                max_total = std::cmp::max(max_total, total);
            }
        }

        max_total
    }
}

#[macro_export]
macro_rules! get {
    ($mat:expr,$x:expr,$y:expr) => {
        $mat[$x as usize][$y as usize]
    };
}

struct Solution;

fn main() {
    // check!([[0, 2, 1, 0], [4, 0, 0, 3], [1, 0, 0, 4], [0, 3, 2, 0]], 7);
    // check!([[1, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 1]], 1);
    check!([[8, 6], [2, 6]], 22);
}

#[macro_export]
macro_rules! check {
    ($grid:expr, $expected:expr) => {
        let actual = Solution::find_max_fish($grid.map(|row| row.to_vec()).to_vec());
        assert_eq!(actual, $expected);
    };
}
