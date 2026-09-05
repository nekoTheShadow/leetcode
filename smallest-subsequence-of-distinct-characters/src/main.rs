use std::collections::{HashMap, HashSet};

impl Solution {
    pub fn smallest_subsequence(s: String) -> String {
        let mut stack = vec![];
        let mut seen = HashSet::new();
        let mut freq = HashMap::new();
        for ch in s.chars() {
            *freq.entry(ch).or_insert(0) += 1;
        }

        for ch in s.chars() {
            *freq.get_mut(&ch).unwrap() -= 1;
            if seen.contains(&ch) {
                continue;
            }
            while let Some(&top) = stack.last()
                && top > ch
                && freq[&top] > 0
            {
                seen.remove(&stack.pop().unwrap());
            }
            stack.push(ch);
            seen.insert(ch);
        }
        stack.iter().collect()
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use crate::Solution;

    #[test]
    fn example1() {
        assert_eq!(Solution::smallest_subsequence("bcabc".to_string()), "abc")
    }
    #[test]
    fn example3() {
        assert_eq!(
            Solution::smallest_subsequence("cbacdcbc".to_string()),
            "acdb"
        )
    }
}
