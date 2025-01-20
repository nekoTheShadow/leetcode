use std::collections::HashMap;

impl Solution {
    pub fn first_complete_index(arr: Vec<i32>, mat: Vec<Vec<i32>>) -> i32 {
        let h = mat.len();
        let w = mat[0].len();

        let mut points = HashMap::new();
        for i in 0..h {
            for j in 0..w {
                points.insert(mat[i][j], (i, j));
            }
        }

        let n = arr.len();
        let mut count_x = HashMap::new();
        let mut count_y = HashMap::new();
        for i in 0..n {
            let (x, y) = points[&arr[i]];
            *count_x.entry(x).or_insert(0) += 1;
            *count_y.entry(y).or_insert(0) += 1;
            if count_x[&x] == w || count_y[&y] == h {
                return i as i32;
            }
        }

        (n - 1) as i32
    }
}

struct Solution;

fn main() {
    testing!([1, 3, 4, 2], [[1, 4], [2, 3]], 2);
    testing!(
        [2, 8, 7, 4, 1, 3, 5, 6, 9],
        [[3, 2, 5], [1, 4, 6], [8, 7, 9]],
        3
    );
    testing!([1, 4, 5, 2, 6, 3], [[4, 3, 5], [1, 2, 6]], 1);
}

#[macro_export]
macro_rules! testing {
    ($arr:expr, $mat:expr, $expected:expr) => {
        assert_eq!(
            Solution::first_complete_index($arr.to_vec(), $mat.map(|a| a.to_vec()).to_vec()),
            $expected
        )
    };
}
