use std::collections::HashSet;

impl Solution {
    pub fn sum_counts(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut total = 0;
        for i in 0..n {
            let mut set = HashSet::new();
            for j in i..n {
                set.insert(nums[j]);
                total += set.len() * set.len();
            }
        }
        total as i32
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
        let nums = [1, 2, 1];
        let output = 15;
        assert_eq!(Solution::sum_counts(nums.to_vec()), output);
    }

    #[test]
    fn example2() {
        let nums = [1, 1];
        let output = 3;
        assert_eq!(Solution::sum_counts(nums.to_vec()), output);
    }
}
