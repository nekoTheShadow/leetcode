use std::collections::HashMap;

impl Solution {
    pub fn minimum_length(s: String) -> i32 {
        let mut d = HashMap::new();
        for ch in s.chars() {
            *d.entry(ch).or_insert(0) += 1;
        }
        d.values().map(|v| if v % 2 == 0 { 2 } else { 1 }).sum()
    }
}
struct Solution;

fn main() {
    assert_eq!(Solution::minimum_length("abaacbcbb".into()), 5);
    assert_eq!(Solution::minimum_length("aa".into()), 2);
}
