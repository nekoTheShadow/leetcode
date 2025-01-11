use std::collections::HashMap;

impl Solution {
    pub fn can_construct(s: String, k: i32) -> bool {
        let k = k as usize;
        let n = s.len();
        if n < k {
            return false;
        }
        if n == k {
            return true;
        }

        let mut d = HashMap::new();
        for ch in s.chars() {
            *d.entry(ch).or_insert(0) += 1;
        }
        d.values().filter(|&&v| v % 2 != 0).count() <= k
    }
}

struct Solution;

fn main() {
    assert!(Solution::can_construct("annabelle".into(), 2));
    assert!(!Solution::can_construct("leetcode".into(), 3));
    assert!(Solution::can_construct("true".into(), 4));
}
