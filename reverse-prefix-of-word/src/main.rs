fn main() {
    assert_eq!(Solution::reverse_prefix("dcbaefd".to_string(), 'd'), "dcbaefd");
    assert_eq!(Solution::reverse_prefix("xyxzxe".to_string(), 'z'), "zxyxxe");
    assert_eq!(Solution::reverse_prefix("abcd".to_string(), 'z'), "abcd");
}

impl Solution {
    pub fn reverse_prefix(word: String, ch: char) -> String {
        if let Some(x) = word.find(ch) {
            word[0..=x].chars().rev().chain(word[x+1..].chars()).collect()
        } else {
            word
        }
    }
}

struct Solution;