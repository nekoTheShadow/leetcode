impl Solution {
    pub fn build_array(nums: Vec<i32>) -> Vec<i32> {
        (0..nums.len()).map(|i| nums[nums[i] as usize]).collect()
    }
}

struct Solution;

fn main() {
    testing!([0, 2, 1, 5, 3, 4], [0, 1, 2, 4, 5, 3]);
    testing!([5, 0, 1, 2, 3, 4], [4, 5, 0, 1, 2, 3]);
}

#[macro_export]
macro_rules! testing {
    ($nums: expr, $output: expr) => {
        assert_eq!(Solution::build_array($nums.to_vec()), $output.to_vec());
    };
}
