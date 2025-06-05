use std::collections::{BTreeSet, HashMap};

impl Solution {
    pub fn smallest_equivalent_string(s1: String, s2: String, base_str: String) -> String {
        let mut g = HashMap::new();
        for (c1, c2) in s1.chars().zip(s2.chars()) {
            g.entry(c1).or_insert(Vec::new()).push(c2);
            g.entry(c2).or_insert(Vec::new()).push(c1);
        }

        let mut smallest = HashMap::new();
        for c in 'a'..='z' {
            let mut stack = vec![c];
            let mut visited = BTreeSet::new();
            while let Some(cur) = stack.pop() {
                visited.insert(cur);
                for nxt in g.get(&cur).unwrap_or(&Vec::new()) {
                    if !visited.contains(nxt) {
                        stack.push(*nxt);
                    }
                }
            }
            smallest.insert(c, *visited.first().unwrap_or(&c));
        }

        base_str.chars().map(|c| smallest[&c]).collect()
    }
}
struct Solution;

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        let s1 = "parker";
        let s2 = "morris";
        let base_str = "parser";
        assert_eq!(
            Solution::smallest_equivalent_string(
                s1.to_string(),
                s2.to_string(),
                base_str.to_string()
            ),
            "makkek".to_string()
        );
    }

    #[test]
    fn example2() {
        let s1 = "hello";
        let s2 = "world";
        let base_str = "hold";
        assert_eq!(
            Solution::smallest_equivalent_string(
                s1.to_string(),
                s2.to_string(),
                base_str.to_string()
            ),
            "hdld".to_string()
        );
    }

    #[test]
    fn example3() {
        let s1 = "leetcode";
        let s2 = "programs";
        let base_str = "sourcecode";
        assert_eq!(
            Solution::smallest_equivalent_string(
                s1.to_string(),
                s2.to_string(),
                base_str.to_string()
            ),
            "aauaaaaada".to_string()
        );
    }
}
