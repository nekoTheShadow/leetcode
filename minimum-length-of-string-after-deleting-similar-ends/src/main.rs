use std::collections::VecDeque;

impl Solution {
    pub fn minimum_length(s: String) -> i32 {
        let mut t = s.chars().collect::<VecDeque<_>>();
        while t.len() > 1 && t.front().unwrap() == t.back().unwrap() {
            let a = *t.front().unwrap();
            while !t.is_empty() && a == *t.front().unwrap() {
                t.pop_front();
            }
            while !t.is_empty() && a == *t.back().unwrap() {
                t.pop_back();
            }
        }
        t.len() as i32
    }
}

struct Solution {}

fn main() {
    println!("{}", Solution::minimum_length("ca".to_string()));
    println!("{}", Solution::minimum_length("cabaabac".to_string()));
    println!("{}", Solution::minimum_length("aabccabba".to_string()));
}
