impl Solution {
    pub fn remove_occurrences(s: String, part: String) -> String {
        let mut stack = String::new();
        for ch in s.chars() {
            stack.push(ch);
            if stack.ends_with(&part) {
                for _ in 0..part.len() {
                    stack.pop();
                }
            }
        }
        stack
    }
}

struct Solution;

fn main() {
    check("daabcbaabcbc", "abc", "dab");
    check("axxxxyyyyb", "xy", "ab");
}

fn check(s: &str, part: &str, expected: &str) {
    assert_eq!(
        Solution::remove_occurrences(s.to_string(), part.to_string()),
        expected.to_string()
    )
}
