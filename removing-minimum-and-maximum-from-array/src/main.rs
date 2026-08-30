use std::println;

impl Solution {
    pub fn minimum_deletions(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        if n == 1 {
            return 1;
        }

        let mut max_i = 0;
        let mut min_i = 0;
        for (i, &v) in nums.iter().enumerate() {
            if nums[max_i] < v {
                max_i = i;
            }
            if nums[min_i] > v {
                min_i = i;
            }
        }
        let i1 = std::cmp::min(max_i, min_i);
        let i2 = std::cmp::max(max_i, min_i);

        let d1 = i2 + 1; // すべて左
        let d2 = n - i1; // すべて右
        let d3 = (i1 + 1) + (n - i2); // どちらも近いほう
        *[d1, d2, d3].iter().min().unwrap() as i32
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
        let nums = [2, 10, 7, 5, 4, 1, 8, 6];
        assert_eq!(Solution::minimum_deletions(nums.to_vec()), 5)
    }

    #[test]
    fn example2() {
        let nums = [0, -4, 19, 1, 8, -2, -3, 5];
        assert_eq!(Solution::minimum_deletions(nums.to_vec()), 3)
    }

    #[test]
    fn example3() {
        let nums = [101];
        assert_eq!(Solution::minimum_deletions(nums.to_vec()), 1)
    }
}
