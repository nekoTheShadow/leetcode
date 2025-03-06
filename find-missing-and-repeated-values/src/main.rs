impl Solution {
    pub fn find_missing_and_repeated_values(grid: Vec<Vec<i32>>) -> Vec<i32> {
        // s1: a+b+c+d
        // t1: a^2+b^2+c^2+d^2
        // s2: a+a+c+d
        // t2: a^2+a^2+c^2+d^2

        let m = grid.len() as i128;
        let n = m * m;

        let s1 = n * (n + 1) / 2;
        let t1 = n * (n + 1) * (2 * n + 1) / 6;
        let mut s2 = 0_i128;
        let mut t2 = 0_i128;
        for &v in grid.iter().flatten() {
            s2 += v as i128;
            t2 += (v * v) as i128;
        }

        let x = s2 - s1; // a-b
        let y = t2 - t1; // a^2+b^2 = (a-b)(a+b)
        let z = y / x; // a+b

        let a = (x + z) / 2;
        let b = (z - x) / 2;
        vec![a as i32, b as i32]
    }
}

struct Solution;

fn main() {
    testing!([[1, 3], [2, 2]], [2, 4]);
    testing!([[9, 1, 7], [8, 9, 2], [3, 4, 6]], [9, 5]);
}

#[macro_export]
macro_rules! testing {
    ($grid:expr, $expected:expr) => {
        let actual = Solution::find_missing_and_repeated_values($grid.map(|x| x.to_vec()).to_vec());
        assert_eq!($expected.to_vec(), actual);
    };
}
