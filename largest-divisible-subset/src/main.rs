impl Solution {
    pub fn largest_divisible_subset(nums: Vec<i32>) -> Vec<i32> {
        let mut nums = nums;
        let n = nums.len();
        nums.sort();
    
        let mut dp = vec![1; n];
        let mut pre = vec![std::usize::MAX; n];
        for i in 0..n {
            for j in i+1..n {
                if nums[j]%nums[i]==0 {
                    if dp[i]+1 > dp[j] {
                        dp[j] = dp[i]+1;
                        pre[j] = i;
                    }
                }
            }
        }

        let mut cur = (0..n).max_by_key(|&i| dp[i]).unwrap();
        let mut ret = vec![];
        while cur != std::usize::MAX {
            ret.push(nums[cur]);
            cur = pre[cur];
        }

        ret
    }
}

struct Solution{}

fn main() {
    println!("{:?}", Solution::largest_divisible_subset(vec![1,2,3]));
    println!("{:?}", Solution::largest_divisible_subset(vec![1,2,4,8]));
}
