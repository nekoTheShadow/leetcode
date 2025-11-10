fn main() {
    assert_eq!(Solution::min_operations(vec![0, 2]), 1);
    assert_eq!(Solution::min_operations(vec![3, 1, 2, 1]), 3);
    assert_eq!(Solution::min_operations(vec![1, 2, 1, 2, 1, 2]), 4);
}

impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        let mut stack = vec![];
        let mut ans = 0;
        for x in nums {
            while stack.last().is_some_and(|&y| y > x) {
                stack.pop();
            }
            if stack.last().is_none_or(|&y| y < x) {
                if x != 0 {
                    ans += 1;
                }
                stack.push(x);
            }
        }
        ans
    }
}

struct Solution;
