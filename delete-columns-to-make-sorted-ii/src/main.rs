use std::collections::HashSet;

use itertools::Itertools;

impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        let n = strs[0].len();
        let mut indexs = HashSet::new();
        for index in 0..n {
            indexs.insert(index);
            if !is_ok(&strs, &indexs) {
                indexs.remove(&index);
            }
        }
        (n - indexs.len()) as i32
    }
}

fn is_ok(strs: &Vec<String>, indexs: &HashSet<usize>) -> bool {
    strs.iter()
        .map(|s| substr(s, indexs))
        .tuple_windows()
        .all(|(s1, s2)| s1 <= s2)
}

fn substr(s: &String, indexs: &HashSet<usize>) -> String {
    s.chars()
        .enumerate()
        .filter_map(|(i, ch)| if indexs.contains(&i) { Some(ch) } else { None })
        .collect()
}

#[cfg(test)]
mod test {
    use crate::Solution;

    #[test]
    fn example1() {
        let strs = ["ca", "bb", "ac"];
        let output = 1;
        assert_eq!(
            Solution::min_deletion_size(strs.map(|s| s.to_string()).to_vec()),
            output
        )
    }

    #[test]
    fn example2() {
        let strs = ["xc", "yb", "za"];
        let output = 0;
        assert_eq!(
            Solution::min_deletion_size(strs.map(|s| s.to_string()).to_vec()),
            output
        )
    }

    #[test]
    fn example3() {
        let strs = ["zyx", "wvu", "tsr"];
        let output = 3;
        assert_eq!(
            Solution::min_deletion_size(strs.map(|s| s.to_string()).to_vec()),
            output
        )
    }

    #[test]
    fn ng1() {
        let strs = ["xga", "xfb", "yfa"];
        let output = 1;
        assert_eq!(
            Solution::min_deletion_size(strs.map(|s| s.to_string()).to_vec()),
            output
        )
    }

    #[test]
    fn ng2() {
        let strs = ["koccmoezl", "hbccayhbd"];
        let output = 3;
        assert_eq!(
            Solution::min_deletion_size(strs.map(|s| s.to_string()).to_vec()),
            output
        )
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}
