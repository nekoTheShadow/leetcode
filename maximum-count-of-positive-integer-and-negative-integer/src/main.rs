impl Solution {
    pub fn maximum_count(nums: Vec<i32>) -> i32 {
        let neg = nums.partition_point(|v| *v < 0);
        let pos = nums.len() - nums.partition_point(|v| *v <= 0);
        std::cmp::max(neg, pos) as i32
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::maximum_count(vec![-2, -1, -1, 1, 2, 3]), 3);
    assert_eq!(Solution::maximum_count(vec![-3, -2, -1, 0, 0, 1, 2]), 3);
    assert_eq!(Solution::maximum_count(vec![5, 20, 66, 1314]), 4);
}
