use std::collections::HashSet;

use itertools::{Itertools, iproduct};

impl Solution {
    pub fn brace_expansion_ii(expression: String) -> Vec<String> {
        build(expression.chars().collect())
            .into_iter()
            .sorted()
            .collect()
    }
}

fn build(s: Vec<char>) -> HashSet<String> {
    let mut i = 0;
    let mut curr = HashSet::from([String::from("")]);
    let mut parts = HashSet::new();

    while i < s.len() {
        if s[i] == '{' {
            let mut j = i;
            let mut depth = 0;
            loop {
                if s[j] == '{' {
                    depth += 1;
                } else if s[j] == '}' {
                    depth -= 1;
                }
                if depth == 0 {
                    break;
                }
                j += 1;
            }

            let options = build(s[i + 1..j].to_vec());
            curr = iproduct!(curr.iter(), options.iter())
                .map(|(a, b)| format!("{}{}", a, b))
                .collect();
            i = j + 1;
        } else if s[i] == ',' {
            parts.extend(curr.into_iter());
            curr = HashSet::from([String::from("")]);
            i += 1;
        } else {
            curr = curr.iter().map(|a| format!("{}{}", a, s[i])).collect();
            i += 1;
        }
    }

    parts.extend(curr.into_iter());
    parts
}
struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use std::assert_eq;

    use crate::Solution;

    #[test]
    fn example1() {
        let expression = "{a,b}{c,{d,e}}";
        let output = ["ac", "ad", "ae", "bc", "bd", "be"];
        assert_eq!(
            Solution::brace_expansion_ii(expression.to_string()),
            output.to_vec()
        );
    }

    #[test]
    fn example2() {
        let expression = "{{a,z},a{b,c},{ab,z}}";
        let output = ["a", "ab", "ac", "z"];
        assert_eq!(
            Solution::brace_expansion_ii(expression.to_string()),
            output.to_vec()
        );
    }
}
