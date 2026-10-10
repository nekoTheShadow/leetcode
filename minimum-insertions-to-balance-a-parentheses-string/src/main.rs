impl Solution {
    pub fn min_insertions(s: String) -> i32 {
        let chars = s.chars().collect::<Vec<_>>();
        let n = s.len();

        let mut count = 0;
        let mut left = 0;
        let mut i = 0;
        while i < n {
            if chars[i] == '(' {
                left += 1;
            } else {
                if left == 0 {
                    count += 1;
                } else {
                    left -= 1;
                }

                if i + 1 < n && chars[i + 1] == ')' {
                    i += 1;
                } else {
                    count += 1;
                }
            }
            i += 1;
        }

        if left > 0 {
            count += left * 2;
        }

        count
    }
}

struct Solution;

#[cfg(test)]
mod test {
    use std::assert_eq;

    use crate::Solution;

    #[test]
    fn example1() {
        let s = "(()))";
        let output = 1;
        assert_eq!(Solution::min_insertions(s.to_string()), output);
    }

    #[test]
    fn example2() {
        let s = "())";
        let output = 0;
        assert_eq!(Solution::min_insertions(s.to_string()), output);
    }

    #[test]
    fn example3() {
        let s = "))())(";
        let output = 3;
        assert_eq!(Solution::min_insertions(s.to_string()), output);
    }
}

fn main() {
    println!("Hello, world!");
}
