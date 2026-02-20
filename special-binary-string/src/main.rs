use itertools::Itertools;

impl Solution {
    pub fn make_largest_special(s: String) -> String {
        if s.len() <= 2 {
            return s;
        }

        let mut count = 0;
        let mut start = 0;
        let mut subs = Vec::new();

        for (i, ch) in s.char_indices() {
            if ch == '0' {
                count += 1;
            } else {
                count -= 1;
            }

            if count == 0 {
                let t = Self::make_largest_special(s[start + 1..i].to_string());
                subs.push(format!("1{}0", t));
                start = i + 1
            }
        }

        subs.into_iter().sorted().rev().collect()
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
        let s = "11011000";
        let output = "11100100";
        assert_eq!(Solution::make_largest_special(s.to_string()), output)
    }

    #[test]
    fn example2() {
        let s = "10";
        let output = "10";
        assert_eq!(Solution::make_largest_special(s.to_string()), output)
    }
}
