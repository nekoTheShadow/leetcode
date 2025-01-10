use std::{cmp::max, collections::HashMap};

impl Solution {
    pub fn word_subsets(words1: Vec<String>, words2: Vec<String>) -> Vec<String> {
        let mut counter = HashMap::new();
        for word in &words2 {
            for (ch, c) in group_by_count(&word) {
                update(&mut counter, ch, c);
            }
        }

        words1
            .into_iter()
            .filter(|word| is_ok(word, &counter))
            .collect()
    }
}

fn update(counter: &mut HashMap<char, i32>, ch: char, new_v: i32) {
    counter
        .entry(ch)
        .and_modify(|old_v| *old_v = max(*old_v, new_v))
        .or_insert(new_v);
}

fn group_by_count(word: &str) -> HashMap<char, i32> {
    let mut d = HashMap::new();
    for ch in word.chars() {
        *d.entry(ch).or_insert(0) += 1;
    }
    d
}

fn is_ok(word: &str, counter: &HashMap<char, i32>) -> bool {
    let w = group_by_count(word);
    counter.iter().all(|(ch, c)| c <= w.get(&ch).unwrap_or(&0))
}

struct Solution;

fn main() {
    testing(
        &["amazon", "apple", "facebook", "google", "leetcode"],
        &["e", "o"],
        &["facebook", "google", "leetcode"],
    );
    testing(
        &["amazon", "apple", "facebook", "google", "leetcode"],
        &["l", "e"],
        &["apple", "google", "leetcode"],
    );
}

fn testing(words1: &[&str], words2: &[&str], expected: &[&str]) {
    let mut actual = Solution::word_subsets(to_vec(words1), to_vec(words2));
    let mut expected = to_vec(expected);

    actual.sort();
    expected.sort();
    assert_eq!(actual, expected);
}

fn to_vec(vals: &[&str]) -> Vec<String> {
    vals.iter().map(|val| val.to_string()).collect()
}
