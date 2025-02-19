impl Solution {
    pub fn get_happy_string(n: i32, k: i32) -> String {
        let mut k = k;
        backtrack(&mut String::from(""), n as usize, &mut k).unwrap_or(String::from(""))
    }
}

fn backtrack(s: &mut String, n: usize, k: &mut i32) -> Option<String> {
    if s.len() == n {
        *k -= 1;
        if *k == 0 {
            return Some(s.clone());
        } else {
            return None;
        }
    }

    for ch in ['a', 'b', 'c'] {
        if s.is_empty() || s.chars().last().unwrap() != ch {
            s.push(ch);
            let ans = backtrack(s, n, k);
            if ans.is_some() {
                return ans;
            }
            s.pop();
        }
    }

    None
}

struct Solution;

fn main() {
    assert_eq!(Solution::get_happy_string(1, 3), String::from("c"));
    assert_eq!(Solution::get_happy_string(1, 4), String::from(""));
    assert_eq!(Solution::get_happy_string(3, 9), String::from("cab"));
}
