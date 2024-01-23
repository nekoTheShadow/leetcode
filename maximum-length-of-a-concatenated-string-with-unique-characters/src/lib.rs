use std::{cmp::max, collections::HashSet};

#[derive(Debug)]
pub struct Solution {}

impl Solution {
    pub fn max_length(arr: Vec<String>) -> i32 {
        let n = arr.len();
        let mut ret = 0;

        for bit in 0..(1<<n) {
            let mut words = vec![];
            for i in 0..n {
                if bit&(1<<i)!=0 {
                    words.push(&arr[i]);
                }

            }

            let mut set: HashSet<char> = HashSet::new();
            let mut ok = true;
            let mut len = 0;
            for word in words {
                len += word.len();
                for ch in word.chars() {
                    if set.contains(&ch) {
                        ok = false;
                        break;
                    }
                    set.insert(ch);
                }
            }

            if ok {
                ret = max(ret, len);
            }
            
        }
        ret as i32
    }
}

#[cfg(test)]
mod unit_tests {
    use super::Solution;

    #[test]
    fn example1() {
        assert_eq!(Solution::max_length(["un", "iq", "ue"].iter().map(|s| s.to_string()).collect()), 4);
    }

    #[test]
    fn example2() {
        assert_eq!(Solution::max_length(["cha", "r", "act", "ers"].iter().map(|s| s.to_string()).collect()), 6);
    }

    #[test]
    fn example3() {
        assert_eq!(Solution::max_length(["abcdefghijklmnopqrstuvwxyz"].iter().map(|s| s.to_string()).collect()), 26);
    }
}
