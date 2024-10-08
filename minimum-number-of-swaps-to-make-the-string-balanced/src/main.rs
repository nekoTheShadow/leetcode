impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        let mut stack = 0;
        let mut count = 0;
        for ch in s.chars() {
            if ch == ']' {
                if stack > 0 {
                    stack -= 1;
                } else {
                    count += 1;
                    stack += 1;
                }
            } else {
                stack += 1;
            }
        }
        (count + stack / 2) / 2
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::min_swaps("][][".to_string()), 1);
    assert_eq!(Solution::min_swaps("]]][[[".to_string()), 2);
    assert_eq!(Solution::min_swaps("[]".to_string()), 0);
}
