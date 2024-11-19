use std::collections::{HashMap, HashSet};

impl Solution {
    pub fn maximum_subarray_sum(nums: Vec<i32>, k: i32) -> i64 {
        let nums = nums.iter().map(|num| *num as i64).collect::<Vec<_>>();
        let k = k as usize;

        let mut counter = HashMap::new();
        let mut repeats = HashSet::new();
        let mut max = 0;
        let mut total = 0;

        for i in 0..k {
            *counter.entry(nums[i]).or_insert(0) += 1;
            total += nums[i];
            if counter[&nums[i]] > 1 {
                repeats.insert(nums[i]);
            }
        }

        if repeats.is_empty() {
            max = std::cmp::max(max, total);
        }

        for i in k..nums.len() {
            counter.entry(nums[i - k]).and_modify(|v| *v -= 1);
            total -= nums[i - k];
            if counter[&nums[i - k]] == 1 {
                repeats.remove(&nums[i - k]);
            }

            *counter.entry(nums[i]).or_insert(0) += 1;
            total += nums[i];
            if counter[&nums[i]] > 1 {
                repeats.insert(nums[i]);
            }

            if repeats.is_empty() {
                max = std::cmp::max(max, total);
            }
        }

        max
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::maximum_subarray_sum(vec![1, 5, 4, 2, 9, 9, 9], 3),
        15
    );
    assert_eq!(Solution::maximum_subarray_sum(vec![4, 4, 4], 3), 0);
}
