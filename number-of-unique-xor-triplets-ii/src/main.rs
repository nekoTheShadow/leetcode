use std::{assert_eq, collections::HashSet};

impl Solution {
    pub fn unique_xor_triplets(nums: Vec<i32>) -> i32 {
        let n = nums.len();

        let mut set1 = HashSet::new();
        for i in 0..n {
            for j in i..n {
                set1.insert(nums[i] ^ nums[j]);
            }
        }

        
        let mut set2 = HashSet::new();
        for i in 0..n {
            for v in &set1 {
                set2.insert(nums[i] ^ v);
            }
        }
        set2.len() as i32
    }
}
struct Solution;

fn main() {
    assert_eq!(Solution::unique_xor_triplets(vec![1, 3]), 2);
    assert_eq!(Solution::unique_xor_triplets(vec![6, 7, 8, 9]), 4);
}
