use std::collections::HashMap;

impl Solution {
    pub fn longest_balanced(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut max_len = 0;
        for i in 0..n {
            let mut d1 = HashMap::new();
            let mut d2 = HashMap::new();
            for j in i..n {
                if nums[j] % 2 == 0 {
                    *d1.entry(nums[j]).or_insert(0) += 1;
                } else {
                    *d2.entry(nums[j]).or_insert(0) += 1;
                }

                if d1.len() == d2.len() {
                    max_len = std::cmp::max(max_len, j - i + 1);
                }
            }
        }
        max_len as i32
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
        let nums = [2, 5, 4, 3];
        assert_eq!(Solution::longest_balanced(nums.to_vec()), 4);
    }

    #[test]
    fn example2() {
        let nums = [3, 2, 2, 5, 4];
        assert_eq!(Solution::longest_balanced(nums.to_vec()), 5);
    }

    #[test]
    fn example3() {
        let nums = [1, 2, 3, 2];
        assert_eq!(Solution::longest_balanced(nums.to_vec()), 3);
    }
}
