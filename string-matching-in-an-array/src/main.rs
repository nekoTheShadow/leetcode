impl Solution {
    pub fn string_matching(words: Vec<String>) -> Vec<String> {
        words
            .iter()
            .filter(|w1| words.iter().any(|w2| *w1 != w2 && w2.contains(*w1)))
            .map(|w| w.to_string())
            .collect()
    }
}
struct Solution;

fn main() {
    testing(&["mass", "as", "hero", "superhero"], &["as", "hero"]);
    testing(&["leetcode", "et", "code"], &["et", "code"]);
    testing(&["blue", "green", "bu"], &[]);
}

fn testing(words: &[&str], expected: &[&str]) {
    let mut expected = expected
        .iter()
        .map(|word| word.to_string())
        .collect::<Vec<_>>();
    expected.sort();

    let mut actual = Solution::string_matching(words.iter().map(|word| word.to_string()).collect());
    actual.sort();

    assert_eq!(expected, actual);
}
