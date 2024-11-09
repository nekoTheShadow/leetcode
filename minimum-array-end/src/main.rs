impl Solution {
    pub fn min_end(n: i32, x: i32) -> i64 {
        let mut y = x as i64;
        let mut m = (n - 1) as i64;

        let mut i = 0;
        while m > 0 {
            while get_bit(y, i) == 1 {
                i += 1;
            }

            y |= get_bit(m, 0) << i;
            i += 1;
            m = m >> 1;
        }
        y
    }
}

fn get_bit(n: i64, i: i64) -> i64 {
    (n >> i) & 1
}

struct Solution;

fn main() {
    println!("{}", Solution::min_end(3, 4));
    println!("{}", Solution::min_end(2, 7));
}
