impl Solution {
    pub fn append_characters(s: String, t: String) -> i32 {
        let n = t.len() as i32;
        n - Solution::f(
            &s.chars().collect::<Vec<_>>(),
            &t.chars().collect::<Vec<_>>(),
            0,
            0,
        )
    }

    pub fn f(s: &[char], t: &[char], x: usize, y: usize) -> i32 {
        if s.len() == x || t.len() == y {
            return 0;
        }

        if s[x] == t[y] {
            return Self::f(s, t, x + 1, y + 1) + 1;
        } else {
            return Self::f(s, t, x + 1, y);
        }
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::append_characters("coaching".to_string(), "coding".to_string())
    );
    println!(
        "{}",
        Solution::append_characters("abcde".to_string(), "a".to_string())
    );
    println!(
        "{}",
        Solution::append_characters("z".to_string(), "abcde".to_string())
    );
}
