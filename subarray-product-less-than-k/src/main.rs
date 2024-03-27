impl Solution {
    pub fn num_subarray_product_less_than_k(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let mut right = 0;
        let mut product = 1;
        let mut ret = 0;

        for left in 0..n {
            while right < n && product * nums[right] < k {
                product *= nums[right];
                right += 1;
            }

            ret += right - left;

            if left == right {
                right += 1;
            } else {
                product /= nums[left];
            }
        }
        return ret as i32;
    }
}

struct Solution {}

fn main() {
    println!(
        "{}",
        Solution::num_subarray_product_less_than_k(vec![10, 5, 2, 6], 100)
    );
    println!(
        "{}",
        Solution::num_subarray_product_less_than_k(vec![1, 2, 3], 0)
    );
}
