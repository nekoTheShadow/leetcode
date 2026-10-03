impl Solution {
    pub fn max_depth_after_split(seq: String) -> Vec<i32> {
        let mut depth = 0;
        let mut groups = Vec::new();
        for ch in seq.chars() {
            if ch == '(' {
                depth += 1;
                groups.push(depth % 2);
            } else {
                groups.push(depth % 2);
                depth -= 1;
            }
        }
        groups
    }
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
        let seq = "(()())";
        let output = [0, 1, 1, 1, 1, 0];
        let actual = Solution::max_depth_after_split(seq.into());

        assert_eq!(check(&seq, &output), check(&seq, &actual));
    }
    #[test]
    fn example2() {
        let seq = "()(())()";
        let output = [0, 0, 0, 1, 1, 0, 1, 1];
        let actual = Solution::max_depth_after_split(seq.into());

        assert_eq!(check(&seq, &output), check(&seq, &actual));
    }

    fn check(seq: &str, output: &[i32]) -> i32 {
        let mut seq_a = String::new();
        let mut seq_b = String::new();
        for (ch, &group) in seq.chars().zip(output) {
            if group == 0 {
                seq_a.push(ch);
            } else {
                seq_b.push(ch);
            }
        }
        std::cmp::max(depth(&seq_a), depth(&seq_b))
    }

    fn depth(seq: &str) -> i32 {
        let mut max_depth = 0;
        let mut depth = 0;
        for ch in seq.chars() {
            if ch == '(' {
                depth += 1;
            } else {
                depth -= 1;
            }
            max_depth = std::cmp::max(max_depth, depth);
        }
        max_depth
    }
}
