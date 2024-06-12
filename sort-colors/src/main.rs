impl Solution {
    pub fn sort_colors(nums: &mut Vec<i32>) {
        let n = nums.len();
        for i in 0..n {
            for j in i + 1..n {
                if nums[i] > nums[j] {
                    nums.swap(i, j);
                }
            }
        }
    }
}

struct Solution;

fn main() {
    let mut nums = vec![2, 0, 2, 1, 1, 0];
    Solution::sort_colors(&mut nums);
    println!("{:?}", nums);

    let mut nums = vec![2, 0, 1];
    Solution::sort_colors(&mut nums);
    println!("{:?}", nums);
}
