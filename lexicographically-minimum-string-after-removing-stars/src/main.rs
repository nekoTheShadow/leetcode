use std::{
    cmp::Reverse,
    collections::{BTreeMap, BTreeSet, BinaryHeap},
};

use itertools::Itertools;

impl Solution {
    pub fn clear_stars(s: String) -> String {
        let mut set = BTreeSet::new();
        for (i, ch) in s.chars().enumerate() {
            if ch == '*' {
                set.pop_first();
            } else {
                set.insert((ch, Reverse(i)));
            }
        }

        set.iter()
            .sorted_by_key(|(_, Reverse(x))| *x)
            .map(|(ch, _)| *ch)
            .collect()
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::clear_stars("aaba*".into()), "aab");
    assert_eq!(Solution::clear_stars("abc".into()), "abc");
}
