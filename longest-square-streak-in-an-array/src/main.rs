impl Solution {
    pub fn longest_square_streak(nums: Vec<i32>) -> i32 {
        let mut nums = nums.into_iter().map(|x| x as i128).collect::<Vec<_>>();
        nums.sort();

        let mut dp = vec![1; nums.len()];
        for (i, x) in nums.iter().enumerate() {
            if let Some(j) = Self::binary_search(&nums, x * x) {
                dp[j] = std::cmp::max(dp[j], dp[i] + 1);
            }
        }

        let &max = dp.iter().max().unwrap();
        if max == 1 {
            -1
        } else {
            max
        }
    }

    fn binary_search(nums: &Vec<i128>, x: i128) -> Option<usize> {
        let n = nums.len() as i128;

        let mut ok = -1_i128;
        let mut ng = n as i128;
        while (ok - ng).abs() > 1 {
            let mi = (ok + ng) / 2;
            if nums[mi as usize] < x {
                ok = mi;
            } else {
                ng = mi;
            }
        }

        ok += 1;
        if ok < n && nums[ok as usize] == x {
            Some(ok as usize)
        } else {
            None
        }
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::longest_square_streak(vec![4, 3, 6, 16, 8, 2])
    );
    println!("{}", Solution::longest_square_streak(vec![2, 3, 5, 6, 7]));
}
