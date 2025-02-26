impl Solution {
    pub fn max_absolute_sum(nums: Vec<i32>) -> i32 {
        let mut sum = 0;
        let mut current_min = 0;
        let mut current_max = 0;
        let mut min = std::i32::MAX;
        let mut max = std::i32::MIN;
        for num in nums {
            sum += num;
            min = std::cmp::min(min, sum - current_max);
            max = std::cmp::max(max, sum - current_min);
            current_max = std::cmp::max(current_max, sum);
            current_min = std::cmp::min(current_min, sum);
        }
        std::cmp::max(min.abs(), max.abs())
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::max_absolute_sum(vec![1, -3, 2, 3, -4]), 5);
    assert_eq!(Solution::max_absolute_sum(vec![2, -5, 1, -4, 3, -2]), 8);
}
