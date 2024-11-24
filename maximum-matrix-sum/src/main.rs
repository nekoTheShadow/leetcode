impl Solution {
    pub fn max_matrix_sum(matrix: Vec<Vec<i32>>) -> i64 {
        let mut total = 0_i64;
        let mut negative_count = 0;
        let mut abs_min_value = i64::MAX;

        for row in matrix {
            for v in row {
                total += v.abs() as i64;
                if v < 0 {
                    negative_count += 1;
                }
                abs_min_value = std::cmp::min(abs_min_value, v.abs() as i64);
            }
        }

        if negative_count % 2 == 1 {
            total -= abs_min_value * 2;
        }
        total
    }
}

struct Solution;

fn main() {
    example!([[1, -1], [-1, 1]], 4);
    example!([[1, 2, 3], [-1, -2, -3], [1, 2, 3]], 16);
}

#[macro_export]
macro_rules! example {
    ($matrix:expr, $expected:expr) => {
        assert_eq!(
            Solution::max_matrix_sum($matrix.map(|row| row.to_vec()).to_vec()),
            $expected
        );
    };
}
