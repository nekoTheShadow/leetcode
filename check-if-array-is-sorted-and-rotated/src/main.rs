impl Solution {
    pub fn check(nums: Vec<i32>) -> bool {
        let mut nums = nums;
        for _ in 0..nums.len() {
            if nums.windows(2).all(|xs| xs[0] <= xs[1]) {
                return true;
            }
            nums.rotate_left(1);
        }
        false
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::check(vec![3, 4, 5, 1, 2]), true);
    assert_eq!(Solution::check(vec![2, 1, 3, 4]), false);
    assert_eq!(Solution::check(vec![1, 2, 3]), true);
}
