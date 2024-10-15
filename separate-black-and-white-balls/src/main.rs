impl Solution {
    pub fn minimum_steps(s: String) -> i64 {
        let mut total = 0;
        let mut n1 = 0;
        for c in s.chars() {
            if c == '0' {
                total += n1;
            } else {
                n1 += 1;
            }
        }
        total
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::minimum_steps("101".into()), 1);
    assert_eq!(Solution::minimum_steps("100".into()), 2);
    assert_eq!(Solution::minimum_steps("0111".into()), 0);
}
