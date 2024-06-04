use std::collections::HashMap;


impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        let mut counter = HashMap::new();
        for ch in s.chars() {
            *counter.entry(ch).or_insert(0) += 1;
        }

        let mut sum = 0;
        let mut has_odd = false;
        for (ch, v) in counter {
            sum += v / 2 * 2;
            if v % 2 == 1 {
                has_odd = true;
            }
        }

        if has_odd {
            sum += 1;
        }
        
        sum
    }
}

struct  Solution;

fn main() {
    println!("{}", Solution::longest_palindrome("abccccdd".to_string()));
    println!("{}", Solution::longest_palindrome("a".to_string()));
}
