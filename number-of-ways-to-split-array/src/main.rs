impl Solution {
    pub fn ways_to_split_array(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut d = vec![0_i128; n + 1];
        for i in 0..n {
            d[i + 1] = d[i] + nums[i] as i128;
        }

        (0..n - 1)
            .filter(|i| {
                let l = d[i + 1] - d[0];
                let r = d[n] - d[i + 1];
                l >= r
            })
            .count() as i32
    }
}

struct Solution;

fn main() {
    assert_eq!(2, Solution::ways_to_split_array(vec![10, 4, -8, 7]));
    assert_eq!(2, Solution::ways_to_split_array(vec![2, 3, 1, 0]));
}
