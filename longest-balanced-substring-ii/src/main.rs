use std::{cmp::max, collections::HashMap};

impl Solution {
    pub fn longest_balanced(s: String) -> i32 {
        let mut ans = 0;
        ans = max(ans, f1(&s));
        ans = max(ans, f2(&s, 'a', 'b', 'c'));
        ans = max(ans, f2(&s, 'b', 'c', 'a'));
        ans = max(ans, f2(&s, 'c', 'a', 'b'));
        ans = max(ans, f3(&s));
        ans
    }
}

fn f1(s: &String) -> i32 {
    let mut pre = 'x';
    let mut cur_len = 0;
    let mut max_len = 0;
    for cur in s.chars() {
        if pre != cur {
            max_len = max(max_len, cur_len);
            cur_len = 0;
        }
        cur_len += 1;
        pre = cur;
    }
    max_len = max(max_len, cur_len);
    max_len
}

fn f2(s: &String, c1: char, c2: char, other: char) -> i32 {
    let mut ans = 0;
    for seg in s.split(other) {
        if seg.is_empty() {
            continue;
        }

        let mut d = HashMap::new();
        d.insert(0, -1);

        let mut diff = 0;
        for (i, ch) in seg.chars().enumerate() {
            if ch == c1 {
                diff += 1
            } else if ch == c2 {
                diff -= 1;
            }
            if let Some(j) = d.get(&diff) {
                ans = max(ans, (i as i32) - j);
            } else {
                d.insert(diff, i as i32);
            }
        }
    }
    ans
}

fn f3(s: &String) -> i32 {
    let mut ans = 0;

    let mut dict = HashMap::new();
    dict.insert((0, 0), -1);

    let mut counter = HashMap::new();
    counter.insert('a', 0);
    counter.insert('b', 0);
    counter.insert('c', 0);

    for (i, ch) in s.chars().enumerate() {
        counter.entry(ch).and_modify(|v| *v += 1);
        let key = (counter[&'a'] - counter[&'b'], counter[&'b'] - counter[&'c']);
        if let Some(j) = dict.get(&key) {
            ans = max(ans, (i as i32) - j);
        } else {
            dict.insert(key, i as i32);
        }
    }

    ans
}

struct Solution;

fn main() {
    println!("Hello World!");
}

#[cfg(test)]
mod test {
    use crate::Solution;

    #[test]
    fn example1() {
        let s = "abbac";
        let output = 4;
        assert_eq!(Solution::longest_balanced(s.to_string()), output);
    }

    #[test]
    fn example2() {
        let s = "aabcc";
        let output = 3;
        assert_eq!(Solution::longest_balanced(s.to_string()), output);
    }

    #[test]
    fn example3() {
        let s = "aba";
        let output = 2;
        assert_eq!(Solution::longest_balanced(s.to_string()), output);
    }
}
