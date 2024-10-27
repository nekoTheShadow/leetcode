impl Solution {
    pub fn count_squares(matrix: Vec<Vec<i32>>) -> i32 {
        let h = matrix.len();
        let w = matrix[0].len();

        let mut s = vec![vec![0; w + 1]; h + 1];
        for i in 0..h {
            for j in 0..w {
                s[i + 1][j + 1] = s[i][j + 1] + s[i + 1][j] - s[i][j] + matrix[i][j];
            }
        }
        
        let mut count = 0;
        for x1 in 0..h {
            for y1 in 0..w {
                for d in 1.. {
                    let x2 = x1 + d;
                    let y2 = y1 + d;
                    if !(x2 <= h && y2 <= w) {
                        break;
                    }
                    if s[x2][y2] - s[x1][y2] - s[x2][y1] + s[x1][y1] == (d * d) as i32 {
                        count += 1;
                    }
                }
            }
        }

        count
    }
}

struct Solution;

fn main() {
    let matrix = [[0, 1, 1, 1], [1, 1, 1, 1], [0, 1, 1, 1]]
        .map(|a| a.to_vec())
        .to_vec();
    assert_eq!(Solution::count_squares(matrix), 15);

    let matrix = [[1, 0, 1], [1, 1, 0], [1, 1, 0]]
        .map(|a| a.to_vec())
        .to_vec();
    assert_eq!(Solution::count_squares(matrix), 7);
}
