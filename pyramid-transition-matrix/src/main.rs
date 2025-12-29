use std::collections::HashMap;

use itertools::Itertools;

impl Solution {
    pub fn pyramid_transition(bottom: String, allowed: Vec<String>) -> bool {
        let graph = allowed
            .iter()
            .map(|s| {
                let (x, y, z) = s.chars().collect_tuple().unwrap();
                ((x, y), z)
            })
            .into_group_map();
        backtrack(&graph, bottom)
    }
}

fn backtrack(graph: &HashMap<(char, char), Vec<char>>, bottom: String) -> bool {
    if bottom.len() == 1 {
        return true;
    }
    transform(graph, bottom)
        .iter()
        .any(|next| backtrack(graph, next.clone()))
}

fn transform(graph: &HashMap<(char, char), Vec<char>>, bottom: String) -> Vec<String> {
    let mut nexts = Vec::new();
    for (c1, c2) in bottom.chars().tuple_windows() {
        if let Some(next) = graph.get(&(c1, c2)) {
            nexts.push(next);
        } else {
            return Vec::new();
        }
    }

    nexts
        .iter()
        .map(|next| next.iter())
        .multi_cartesian_product()
        .map(|next| next.into_iter().collect())
        .collect_vec()
}

struct Solution;

fn main() {}

#[cfg(test)]
mod test {
    use crate::Solution;

    #[test]
    fn example2() {
        let bottom = "AAAA";
        let allowed = ["AAB", "AAC", "BCD", "BBE", "DEF"];
        let output = false;
        assert_eq!(
            Solution::pyramid_transition(
                bottom.to_string(),
                allowed.map(|s| s.to_string()).to_vec()
            ),
            output
        )
    }

    #[test]
    fn example1() {
        let bottom = "BCD";
        let allowed = ["BCC", "CDE", "CEA", "FFF"];
        let output = true;
        assert_eq!(
            Solution::pyramid_transition(
                bottom.to_string(),
                allowed.map(|s| s.to_string()).to_vec()
            ),
            output
        )
    }
}
