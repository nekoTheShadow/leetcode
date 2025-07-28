use itertools::Itertools;

impl Solution {
    pub fn count_max_or_subsets(nums: Vec<i32>) -> i32 {
        let max = nums.iter().fold(0, |acc, num| acc | num);
        nums.iter()
            .powerset()
            .filter(|set| set.iter().fold(0, |acc, num| acc | *num) == max)
            .count() as i32
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::count_max_or_subsets(vec![3, 1]), 2);
    assert_eq!(Solution::count_max_or_subsets(vec![2, 2, 2]), 7);
    assert_eq!(Solution::count_max_or_subsets(vec![3, 2, 1, 5]), 6);
}
