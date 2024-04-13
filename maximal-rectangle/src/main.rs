impl Solution {
    pub fn maximal_rectangle(matrix: Vec<Vec<char>>) -> i32 {
        let C = matrix.len();
        let R = matrix[0].len();

        let mut A = vec![vec![0; R]; C];
        for c in 0..C {
            for r in 0..R {
                if matrix[c][r] == '0' {
                    continue;
                }

                A[c][r] = 1;
                if c >= 1 {
                    A[c][r] += A[c - 1][r];
                }
            }
        }

        let mut max_rec = 0;
        for c in 0..C {
            for i in 0..R {
                let mut min_h = A[c][i];
                for j in i..R {
                    min_h = min_h.min(A[c][j]);
                    let rec = min_h * (j - i + 1);
                    max_rec = max_rec.max(rec);
                }
            }
        }
        max_rec as i32
    }
}

struct Solution;

fn main() {
    let matrix = vec![
        vec!['1', '0', '1', '0', '0'],
        vec!['1', '0', '1', '1', '1'],
        vec!['1', '1', '1', '1', '1'],
        vec!['1', '0', '0', '1', '0'],
    ];
    println!("{}", Solution::maximal_rectangle(matrix));

    let matrix = vec![vec!['0']];
    println!("{}", Solution::maximal_rectangle(matrix));

    let matrix = vec![vec!['1']];
    println!("{}", Solution::maximal_rectangle(matrix));

    let matrix = vec![vec!['0', '1'], vec!['1', '0']];
    println!("{}", Solution::maximal_rectangle(matrix));
}
