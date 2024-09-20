impl Solution {
    pub fn shortest_palindrome(s: String) -> String {
        for i in (0..=s.len()).rev() {
            let u = Self::reverse(&s[i..]) + &s;
            if u == Self::reverse(&u) {
                return u;
            }
        }
        panic!()
    }

    fn reverse(s: &str) -> String {
        s.chars().rev().collect::<String>()
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::shortest_palindrome("aacecaaa".to_string()),
        "aaacecaaa"
    );
    assert_eq!(Solution::shortest_palindrome("abcd".to_string()), "dcbabcd");
    assert_eq!(Solution::shortest_palindrome("a".to_string()), "a");
}
