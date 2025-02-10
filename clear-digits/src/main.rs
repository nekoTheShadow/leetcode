impl Solution {
    pub fn clear_digits(s: String) -> String {
        let mut stack = Vec::new();
        for ch in s.chars() {
            if ch.is_ascii_digit() && check(&stack) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        stack.iter().collect()
    }
}

fn check(stack: &[char]) -> bool {
    if let Some(&pre) = stack.last() {
        if pre.is_ascii_lowercase() {
            return true;
        }
    }
    false
}


struct Solution;

fn main() {
    testing("abc", "abc");
    testing("cb34", "");
}

fn testing(s: &str, expected: &str) {
    assert_eq!(Solution::clear_digits(s.to_string()), expected.to_string());
}
