impl Solution {
    pub fn rotate_the_box(bx: Vec<Vec<char>>) -> Vec<Vec<char>> {
        let mut a = bx;
        let h = a.len();
        let w = a[0].len();

        for row in &mut a {
            for i in (0..w).rev() {
                for j in i..w - 1 {
                    if row[j] == '#' && row[j + 1] == '.' {
                        let tmp = row[j];
                        row[j] = row[j + 1];
                        row[j + 1] = tmp;
                    } else {
                        break;
                    }
                }
            }
        }

        let mut b = vec![vec![' '; h]; w];
        for i in 0..w {
            for j in 0..h {
                b[i][j] = a[h - 1 - j][i];
            }
        }
        b
    }
}

struct Solution;

fn main() {
    example!([["#", ".", "#"]], [["."], ["#"], ["#"]]);
    example!(
        [["#", ".", "*", "."], ["#", "#", "*", "."]],
        [["#", "."], ["#", "#"], ["*", "*"], [".", "."]]
    );
    example!(
        [
            ["#", "#", "*", ".", "*", "."],
            ["#", "#", "#", "*", ".", "."],
            ["#", "#", "#", ".", "#", "."],
        ],
        [
            [".", "#", "#"],
            [".", "#", "#"],
            ["#", "#", "*"],
            ["#", "*", "."],
            ["#", ".", "*"],
            ["#", ".", "."],
        ]
    );
}

#[macro_export]
macro_rules! to_char_matrix {
    ($a:expr) => {
        $a.map(|row| {
            row.iter()
                .map(|s| s.chars().next().unwrap())
                .collect::<Vec<_>>()
        })
        .to_vec()
    };
}

#[macro_export]
macro_rules! example {
    ($a:expr, $b:expr) => {
        assert_eq!(
            Solution::rotate_the_box(to_char_matrix!($a)),
            to_char_matrix!($b)
        );
    };
}
