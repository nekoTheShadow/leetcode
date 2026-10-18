impl Solution {
    pub fn max_alternating_sum(nums: Vec<i32>) -> i64 {
        let mut nums = nums;
        nums.sort_unstable_by_key(|num| num.abs());

        let n = nums.len();
        square_sum(&nums[n/2..n]) - square_sum(&nums[0..n/2])
    }
}

fn square_sum(nums: &[i32]) -> i64 {
    nums.iter().map(|num| (num * num) as i64).sum()
}



struct Solution;

fn main() {
    println!("Hello, world!");
}
