impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let n = nums.len();
        (0..(1<<n)).map(|bit| {
            (0..n).filter(|i| (bit >> i) & 1 == 1).map(|i| nums[i]).collect()
        }).collect()
    }
}

struct Solution;

fn main() {
    println!("{:?}", Solution::subsets(vec![1, 2, 3]));
    println!("{:?}", Solution::subsets(vec![0]));
}
