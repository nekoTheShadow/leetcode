use itertools::Itertools;

impl Solution {
    pub fn make_fancy_string(s: String) -> String {
        s.chars()
            .dedup_with_count()
            .flat_map(|(count, ch)| std::iter::repeat_n(ch, std::cmp::min(2, count)))
            .collect()
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::make_fancy_string("leeetcode".into()), "leetcode");
    assert_eq!(Solution::make_fancy_string("aaabaaaa".into()), "aabaa");
    assert_eq!(Solution::make_fancy_string("aab".into()), "aab");
}
