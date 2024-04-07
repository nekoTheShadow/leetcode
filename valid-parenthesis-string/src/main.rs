use std::collections::HashMap;

impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        Self::f(&mut HashMap::new(), &s, 0, 0)
    }

    pub fn f(memo: &mut HashMap<(usize, usize), bool>, s: &str, i: usize, count: usize) -> bool {
        if i == s.len() {
            return count == 0;
        }

        if let Some(&v) = memo.get(&(i, count)) {
            return v;
        }

        let mut ret = false;
        if &s[i..i + 1] == "(" {
            ret = Self::f(memo, s, i + 1, count + 1);
        } else if &s[i..i + 1] == ")" {
            if count == 0 {
                ret = false;
            } else {
                ret = Self::f(memo, s, i + 1, count - 1);
            }
        } else {
            if count == 0 {
                ret = Self::f(memo, s, i + 1, count + 1) || Self::f(memo, s, i + 1, count);
            } else {
                ret = Self::f(memo, s, i + 1, count + 1)
                    || Self::f(memo, s, i + 1, count)
                    || Self::f(memo, s, i + 1, count - 1);
            }
        }
        memo.insert((i, count), ret);
        ret
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::check_valid_string("()".to_string()));
    println!("{}", Solution::check_valid_string("(*)".to_string()));
    println!("{}", Solution::check_valid_string("(*))".to_string()));
    println!("{}", Solution::check_valid_string("(**(".to_string()));
}
