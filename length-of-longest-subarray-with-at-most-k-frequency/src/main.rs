use std::collections::HashMap;

impl Solution {
    pub fn max_subarray_length(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let mut right = 0;
        let mut counter = HashMap::new();
        let mut ret = 0;
        for left in 0..n {
            while right < n && counter.get(&nums[right]).unwrap_or(&0) + 1 <= k {
                *counter.entry(nums[right]).or_insert(0) += 1;
                right += 1;
            }

            ret = ret.max(right - left);

            if left == right {
                right += 1;
            } else {
                counter.entry(nums[left]).and_modify(|v| *v -= 1);
            }
        }
        ret as i32
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::max_subarray_length(vec![1, 2, 3, 1, 2, 3, 1, 2], 2)
    );
    println!(
        "{}",
        Solution::max_subarray_length(vec![1, 2, 1, 2, 1, 2, 1, 2], 1)
    );
    println!(
        "{}",
        Solution::max_subarray_length(vec![5, 5, 5, 5, 5, 5, 5], 4)
    );
}
