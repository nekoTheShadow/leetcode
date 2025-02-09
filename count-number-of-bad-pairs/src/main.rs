use std::collections::HashMap;

impl Solution {
    pub fn count_bad_pairs(nums: Vec<i32>) -> i64 {
        let n = nums.len();

        let mut good = 0;
        let mut counter = HashMap::new();
        for i in 0..n {
            let num = nums[i] as usize;
            good += counter.get(&(num - i)).unwrap_or(&0);
            *counter.entry(num - i).or_insert(0) += 1;
        }

        ((n * (n - 1)) / 2 - good) as i64
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::count_bad_pairs(vec![4, 1, 3, 3]), 5);
    assert_eq!(Solution::count_bad_pairs(vec![1, 2, 3, 4, 5]), 0);
}
