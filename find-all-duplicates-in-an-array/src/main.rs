impl Solution {
    pub fn find_duplicates(nums: Vec<i32>) -> Vec<i32> {
        let mut nums = nums;
        let mut ret = Vec::new();
        for i in 0..nums.len() {
            let x = (nums[i].abs() - 1) as usize;
            if nums[x].is_negative() {
                ret.push(nums[i].abs())
            }
            nums[x] *= -1
        }
        ret 
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::find_duplicates(vec![4,3,2,7,8,2,3,1]), vec![2,3]);
    assert_eq!(Solution::find_duplicates(vec![1,1,2]), vec![1]);
    assert_eq!(Solution::find_duplicates(vec![1]), vec![]);
}
