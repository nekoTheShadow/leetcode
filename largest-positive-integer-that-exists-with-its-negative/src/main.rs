use std::{collections::HashSet, ops::Neg};

impl Solution {
    pub fn find_max_k(nums: Vec<i32>) -> i32 {
        let set = nums.iter().filter(|num| num.is_negative()).collect::<HashSet<_>>();
        *nums.iter().filter(|num| num.is_positive() && set.contains(&num.neg())).max().unwrap_or(&-1)
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::find_max_k(vec![-1,2,-3,3]), 3);
    assert_eq!(Solution::find_max_k(vec![-1,10,6,7,-7,1]), 7);
    assert_eq!(Solution::find_max_k(vec![-10,8,6,7,-2,-3]), -1);   
}
