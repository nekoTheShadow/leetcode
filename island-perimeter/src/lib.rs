impl Solution {
    pub fn island_perimeter(grid: Vec<Vec<i32>>) -> i32 {
        let m = grid.len() as i32;
        let n = grid[0].len() as i32;

        let mut ret = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i as usize][j as usize] == 0 {
                    continue;
                }
                for (di, dj) in [(0, 1), (0, -1), (1, 0), (-1, 0)] {
                    let ni = i + di;
                    let nj = j + dj;
                    if !(0 <= ni
                        && ni < m
                        && 0 <= nj
                        && nj < n
                        && grid[ni as usize][nj as usize] == 1)
                    {
                        ret += 1
                    }
                }
            }
        }

        ret
    }
}

#[cfg(test)]
mod tests {
    use crate::Solution;

    #[test]
    fn example1() {
        let grid = [[0, 1, 0, 0], [1, 1, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0]]
            .iter()
            .map(|v| v.to_vec())
            .collect::<Vec<_>>();
        assert_eq!(Solution::island_perimeter(grid), 16);
    }

    #[test]
    fn example2() {
        let grid = [[1]].iter().map(|v| v.to_vec()).collect::<Vec<_>>();
        assert_eq!(Solution::island_perimeter(grid), 4);
    }

    #[test]
    fn example3() {
        let grid = [[1, 0]].iter().map(|v| v.to_vec()).collect::<Vec<_>>();
        assert_eq!(Solution::island_perimeter(grid), 4);
    }
}

struct Solution;

