impl Solution {
    pub fn is_array_special(nums: Vec<i32>) -> bool {
        nums.windows(2).all(|xs| xs[0] % 2 != xs[1] % 2)
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::is_array_special(vec![1]), true);
    assert_eq!(Solution::is_array_special(vec![2, 1, 4]), true);
    assert_eq!(Solution::is_array_special(vec![4, 3, 1, 6]), false);
}
