use std::collections::HashMap;

impl Solution {
    pub fn max_freq_sum(s: String) -> i32 {
        let mut d1 = HashMap::new();
        let mut d2 = HashMap::new();
        for ch in s.chars() {
            if ch == 'a' || ch == 'i' || ch == 'u' || ch == 'e' || ch == 'o' {
                *d1.entry(ch).or_insert(0) += 1;
            } else {
                *d2.entry(ch).or_insert(0) += 1;
            }
        }
        d1.values().max().unwrap_or(&0) + d2.values().max().unwrap_or(&0)
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::max_freq_sum(String::from("successes")), 6);
    assert_eq!(Solution::max_freq_sum(String::from("aeiaeia")), 3);
}
