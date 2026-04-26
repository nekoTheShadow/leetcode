impl Solution {
    pub fn contains_cycle(grid: Vec<Vec<char>>) -> bool {
        let h = grid.len();
        let w = grid[0].len();
        let mut visited = vec![vec![false; w]; h];

        for i in 0..h {
            for j in 0..w {
                if visited[i][j] {
                    continue;
                }
                if dfs(&grid, &mut visited, i as i32, j as i32, -1, -1) {
                    return true;
                }
            }
        }

        false
    }
}

fn dfs(
    grid: &Vec<Vec<char>>,
    visited: &mut Vec<Vec<bool>>,
    cur_x: i32,
    cur_y: i32,
    pre_x: i32,
    pre_y: i32,
) -> bool {
    let h = grid.len() as i32;
    let w = grid[0].len() as i32;

    // visited[cur_x][cur_y] = true;
    mat_ref!(visited, cur_x, cur_y) = true;
    for (dx, dy) in [(0, 1), (0, -1), (1, 0), (-1, 0)] {
        let nxt_x = cur_x + dx;
        let nxt_y = cur_y + dy;
        // 範囲外
        if !(0 <= nxt_x && nxt_x < h && 0 <= nxt_y && nxt_y < w) {
            continue;
        }
        // ひとつ前と同じ
        if pre_x == nxt_x && pre_y == nxt_y {
            continue;
        }
        // 接続していない
        if mat_ref!(grid, cur_x, cur_y) != mat_ref!(grid, nxt_x, nxt_y) {
            continue;
        }
        // 次が訪問済みの場合は閉路あり
        if mat_ref!(visited, nxt_x, nxt_y) {
            return true;
        }
        if dfs(grid, visited, nxt_x, nxt_y, cur_x, cur_y) {
            return true;
        }
    }

    false
}

#[macro_export]
macro_rules! mat_ref {
    ($arr:expr, $i:expr, $j:expr) => {
        $arr[$i as usize][$j as usize]
    };
}


struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        let grid = [
            ["a", "a", "a", "a"],
            ["a", "b", "b", "a"],
            ["a", "b", "b", "a"],
            ["a", "a", "a", "a"],
        ]
        .map(|row| row.map(|s| s.chars().next().unwrap()).to_vec())
        .to_vec();
        assert_eq!(Solution::contains_cycle(grid), true);
    }

    #[test]
    fn example2() {
        let grid = [
            ["c", "c", "c", "a"],
            ["c", "d", "c", "c"],
            ["c", "c", "e", "c"],
            ["f", "c", "c", "c"],
        ]
        .map(|row| row.map(|s| s.chars().next().unwrap()).to_vec())
        .to_vec();
        assert_eq!(Solution::contains_cycle(grid), true);
    }

    #[test]
    fn example3() {
        let grid = [["a", "b", "b"], ["b", "z", "b"], ["b", "b", "a"]]
            .map(|row| row.map(|s| s.chars().next().unwrap()).to_vec())
            .to_vec();
        assert_eq!(Solution::contains_cycle(grid), false);
    }
}
