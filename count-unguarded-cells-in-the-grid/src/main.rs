impl Solution {
    pub fn count_unguarded(m: i32, n: i32, guards: Vec<Vec<i32>>, walls: Vec<Vec<i32>>) -> i32 {
        let m = m as usize;
        let n = n as usize;
        let mut matrix = vec![vec!["O"; n]; m];

        for guard in guards {
            matrix[guard[0] as usize][guard[1] as usize] = "G";
        }
        for wall in walls {
            matrix[wall[0] as usize][wall[1] as usize] = "W";
        }

        for i in 0..m {
            let mut guard = false;
            for j in 0..n {
                if matrix[i][j] == "O" && guard {
                    matrix[i][j] = "X";
                }
                if matrix[i][j] == "G" {
                    guard = true;
                }
                if matrix[i][j] == "W" {
                    guard = false;
                }
            }
        }

        for i in 0..m {
            let mut guard = false;
            for j in (0..n).rev() {
                if matrix[i][j] == "O" && guard {
                    matrix[i][j] = "X";
                }
                if matrix[i][j] == "G" {
                    guard = true;
                }
                if matrix[i][j] == "W" {
                    guard = false;
                }
            }
        }

        for j in 0..n {
            let mut guard = false;
            for i in 0..m {
                if matrix[i][j] == "O" && guard {
                    matrix[i][j] = "X";
                }
                if matrix[i][j] == "G" {
                    guard = true;
                }
                if matrix[i][j] == "W" {
                    guard = false;
                }
            }
        }

        for j in 0..n {
            let mut guard = false;
            for i in (0..m).rev() {
                if matrix[i][j] == "O" && guard {
                    matrix[i][j] = "X";
                }
                if matrix[i][j] == "G" {
                    guard = true;
                }
                if matrix[i][j] == "W" {
                    guard = false;
                }
            }
        }

        let mut count = 0;
        for i in 0..m {
            for j in 0..n {
                if matrix[i][j] == "O" {
                    count += 1;
                }
            }
        }
        count
    }
}
struct Solution;

fn main() {
    assert_eq!(
        Solution::count_unguarded(
            4,
            6,
            [[0, 0], [1, 1], [2, 3]].map(|row| row.to_vec()).to_vec(),
            [[0, 1], [2, 2], [1, 4]].map(|row| row.to_vec()).to_vec()
        ),
        7
    );
    assert_eq!(
        Solution::count_unguarded(
            3,
            3,
            [[1, 1]].map(|row| row.to_vec()).to_vec(),
            [[0, 1], [1, 0], [2, 1], [1, 2]]
                .map(|row| row.to_vec())
                .to_vec()
        ),
        4
    );
}
