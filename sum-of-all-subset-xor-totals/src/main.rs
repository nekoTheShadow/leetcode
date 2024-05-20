impl Solution {
    pub fn subset_xor_sum(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        (0..1<<n).map(|bit| {
            (0..n).filter(|i| (bit >> i) & 1 == 1).map(|i| nums[i]).reduce(|acc, v| acc ^ v).unwrap_or(0)
        }).sum()
    }
}
struct Solution;

fn main() {
    println!("{}", Solution::subset_xor_sum(vec![1, 3]));
    println!("{}", Solution::subset_xor_sum(vec![5, 1, 6]));
    println!("{}", Solution::subset_xor_sum(vec![3, 4, 5, 6, 7, 8]));
}
