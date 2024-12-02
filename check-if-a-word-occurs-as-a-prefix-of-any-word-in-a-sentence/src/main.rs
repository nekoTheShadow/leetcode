struct Solution;

impl Solution {
    pub fn is_prefix_of_word(sentence: String, search_word: String) -> i32 {
        sentence
            .split_ascii_whitespace()
            .position(|target| target.starts_with(&search_word))
            .map(|i| (i + 1) as i32)
            .unwrap_or(-1)
    }
}

fn main() {
    assert_eq!(
        4,
        Solution::is_prefix_of_word("i love eating burger".into(), "burg".into())
    );
    assert_eq!(
        2,
        Solution::is_prefix_of_word("this problem is an easy problem".into(), "pro".into())
    );
    assert_eq!(
        -1,
        Solution::is_prefix_of_word("i am tired".into(), "you".into())
    );
}
