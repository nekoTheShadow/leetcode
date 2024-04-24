impl Solution {
    pub fn tribonacci(n: i32) -> i32 {
        (0..n).fold((0, 1, 1), |(t0, t1, t2), _| (t1, t2, t0 + t1 + t2)).0
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::tribonacci(4));
    println!("{}", Solution::tribonacci(25));
}
