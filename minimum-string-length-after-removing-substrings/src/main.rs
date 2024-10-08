use std::collections::VecDeque;

fn main() {
    assert_eq!(Solution::min_length("ABFCACDB".to_string()), 2);
    assert_eq!(Solution::min_length("ACBBD".to_string()), 5);
}

struct Solution;

impl Solution {
    pub fn min_length(s: String) -> i32 {
        let mut stack = VecDeque::new();
        for ch in s.chars() {
            if (stack.back() == Some(&'A') && ch == 'B')
                || (stack.back() == Some(&'C') && ch == 'D')
            {
                stack.pop_back();
            } else {
                stack.push_back(ch);
            }
        }
        stack.len() as i32
    }
}
