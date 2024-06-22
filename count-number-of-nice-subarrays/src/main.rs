use std::collections::HashMap;

impl Solution {
    pub fn number_of_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let mut d = vec![0; n + 1];
        for i in 0..n {
            if nums[i] % 2 == 0 {
                d[i + 1] = d[i];
            } else {
                d[i + 1] = d[i] + 1;
            }
        }

        let mut map = HashMap::new();
        let mut ret = 0;
        for i in 0..=n {
            ret += map.get(&(d[i] - k)).unwrap_or(&0);
            *map.entry(&d[i]).or_insert(0) += 1;
        }
        ret
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::number_of_subarrays(vec![1, 1, 2, 1, 1], 3));
    println!("{}", Solution::number_of_subarrays(vec![2, 4, 6], 1));
    println!(
        "{}",
        Solution::number_of_subarrays(vec![2, 2, 2, 1, 2, 2, 1, 2, 2, 2], 2)
    );
}
