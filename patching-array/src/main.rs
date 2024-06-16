impl Solution {
    pub fn min_patches(nums: Vec<i32>, n: i32) -> i32 {
        let nums = nums.iter().map(|num| *num as i128).collect::<Vec<_>>();
        let n = n as i128;

        let mut miss = 1 as i128;
        let mut i = 0;
        let mut patch = 0;

        while miss <= n {
            if i < nums.len() && nums[i] <= miss {
                miss += nums[i];
                i += 1;
            } else {
                miss += miss;
                patch += 1;
            }
        }

        patch
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::min_patches(vec![1, 3], 6), 1);
    assert_eq!(Solution::min_patches(vec![1, 5, 10], 20), 2);
    assert_eq!(Solution::min_patches(vec![1, 2, 2], 5), 0);

    assert_eq!(Solution::min_patches(vec![1,2,31,33], 2147483647), 28);
}
