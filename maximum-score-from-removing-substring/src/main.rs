use std::{char, collections::VecDeque};

impl Solution {
    pub fn maximum_gain(s: String, x: i32, y: i32) -> i32 {
        let mut ret = 0;

        if x < y {
            let t = Self::remove_string(&s, 'b', 'a');
            ret += y * ((s.len() - t.len()) as i32 / 2);
            let u = Self::remove_string(&t, 'a', 'b');
            ret += x * ((t.len() - u.len()) as i32 / 2);
        } else {
            let t = Self::remove_string(&s, 'a', 'b');
            ret += x * ((s.len() - t.len()) as i32 / 2);
            let u = Self::remove_string(&t, 'b', 'a');
            ret += y * ((t.len() - u.len()) as i32 / 2);
        }

        ret
    }

    fn remove_string(s: &String, c1: char, c2: char) -> String {
        let mut stack = VecDeque::new();
        for c in s.chars() {
            if c == c2 && !stack.is_empty() && stack.back() == Some(&c1) {
                stack.pop_back();
            } else {
                stack.push_back(c);
            }
        }
        stack.iter().collect::<String>()
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::maximum_gain("cdbcbbaaabab".to_string(), 4, 5), 19);
    assert_eq!(Solution::maximum_gain("aabbaaxybbaabb".to_string(), 5, 4), 20);
}