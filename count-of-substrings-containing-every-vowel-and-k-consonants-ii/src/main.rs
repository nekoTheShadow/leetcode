use std::collections::{HashMap, HashSet};

impl Solution {
    pub fn count_of_substrings(word: String, k: i32) -> i64 {
        let word = word.chars().collect::<Vec<_>>();
        f(&word, k) - f(&word, k + 1)
    }
}

fn f(word: &[char], k: i32) -> i64 {
    let vowels = "aiueo".chars().collect::<HashSet<_>>();
    let mut c1 = HashMap::new();
    let mut c2 = 0;
    let n = word.len();
    let mut ret = 0;
    let mut l = 0;
    for r in 0..n {
        let c = word[r];
        if vowels.contains(&c) {
            *c1.entry(c).or_insert(0) += 1;
        } else {
            c2 += 1;
        }

        while c1.len() == 5 && c2 >= k {
            ret += n - r;

            let d = word[l];
            if vowels.contains(&d) {
                *c1.get_mut(&d).unwrap() -= 1;
                if c1[&d] == 0 {
                    c1.remove(&d);
                }
            } else {
                c2 -= 1;
            }

            l += 1;
        }
    }
    ret as i64
}


struct Solution;

fn main() {
    assert_eq!(Solution::count_of_substrings("aeioqq".into(), 1), 0);
    assert_eq!(Solution::count_of_substrings("aeiou".into(), 0), 1);
    assert_eq!(Solution::count_of_substrings("ieaouqqieaouqq".into(), 1), 3);
}
