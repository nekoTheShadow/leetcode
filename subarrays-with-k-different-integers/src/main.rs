use std::collections::HashMap;

impl Solution {
    pub fn subarrays_with_k_distinct(nums: Vec<i32>, k: i32) -> i32 {
        let k = k as usize;
        Self::count(&nums, k) - Self::count(&nums, k - 1)
    }

    fn count(nums: &[i32], k: usize) -> i32 {
        let n = nums.len();
        let mut right = 0;
        let mut map = HashMap::new();

        let mut ret = 0;
        for left in 0..n {
            while right < n && (map.len() < k || (map.len() == k && map.contains_key(&nums[right])))
            {
                *map.entry(&nums[right]).or_insert(0) += 1;
                right += 1;
            }

            ret += right - left;
            if left == right {
                right += 1;
            } else {
                if map[&nums[left]] == 1 {
                    map.remove(&nums[left]);
                } else {
                    map.insert(&nums[left], map[&nums[left]] - 1);
                }
            }
        }
        ret as i32
    }
}
struct Solution {}

fn main() {
    println!(
        "{}",
        Solution::subarrays_with_k_distinct(vec![1, 2, 1, 2, 3], 2)
    );
    println!(
        "{}",
        Solution::subarrays_with_k_distinct(vec![1, 2, 1, 3, 4], 3)
    );
    println!("{}", Solution::subarrays_with_k_distinct(vec![1, 2], 1));
    println!(
        "{}",
        Solution::subarrays_with_k_distinct(vec![2, 1, 1, 1, 2], 1)
    );
}
