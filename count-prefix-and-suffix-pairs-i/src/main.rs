impl Solution {
    pub fn count_prefix_suffix_pairs(words: Vec<String>) -> i32 {
        let n = words.len();
        let mut c = 0;
        for i in 0..n {
            for j in i + 1..n {
                if is_prefix_and_suffix(&words[i], &words[j]) {
                    c += 1;
                }
            }
        }
        c
    }
}

fn is_prefix_and_suffix(str1: &str, str2: &str) -> bool {
    str2.starts_with(str1) && str2.ends_with(str1)
}

struct Solution;

fn main() {
    testing(&["a", "aba", "ababa", "aa"], 4);
    testing(&["abab", "ab"], 0);
}

fn testing(words: &[&str], expected: i32) {
    let actual =
        Solution::count_prefix_suffix_pairs(words.iter().map(|word| word.to_string()).collect());
    assert_eq!(actual, expected)
}
