use std::collections::HashMap;

impl Solution {
    pub fn num_subarrays_with_sum(nums: Vec<i32>, goal: i32) -> i32 {
        let n = nums.len();
        
        let mut d = vec![0_i32; n + 1];
        for i in 0..n {
            d[i + 1] = d[i] + nums[i];
        }

        let mut h = HashMap::new();
        let mut ret = 0;
        for (i, v) in d.iter().enumerate() {
            if let Some(c) = h.get(&(v - goal)) {
                ret += c;
            }
            *h.entry(d[i]).or_insert(0) += 1;
        }

        ret
    }
}


struct Solution {}

fn main() {
    println!(
        "{}",
        Solution::num_subarrays_with_sum(vec![1, 0, 1, 0, 1], 2)
    );
    println!(
        "{}",
        Solution::num_subarrays_with_sum(vec![0, 0, 0, 0, 0], 0)
    );
}
