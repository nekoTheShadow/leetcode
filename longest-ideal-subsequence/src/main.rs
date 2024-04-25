impl Solution {
    pub fn longest_ideal_string(s: String, k: i32) -> i32 {
        let n = s.len();
        let mut dp = vec![1; n];
        let mut a = vec![i32::MIN; 26];

        for (i, c) in s.chars().enumerate() {
            for d in 'a'..='z' {
                if (c as i32 - d as i32).abs() <= k {
                    dp[i] = dp[i].max(a[d as usize - 'a' as usize] + 1);
                }
            }
            a[c as usize - 'a' as usize] = a[c as usize - 'a' as usize].max(dp[i]);
        }

        *dp.iter().max().unwrap()
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::longest_ideal_string("acfgbd".to_string(), 2)
    );
    println!("{}", Solution::longest_ideal_string("abcd".to_string(), 3));
}
