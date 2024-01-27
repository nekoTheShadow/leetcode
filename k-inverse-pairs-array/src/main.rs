struct Solution{}

impl Solution {
    pub fn k_inverse_pairs(n: i32, k: i32) -> i32 {
        let n = n as usize;
        let k = k as usize;
        
        let mut dp = vec![vec![0; k+1]; n+1];
        dp[1][0] = 1;

        for p in 1..n {
            for q in 0..k+1 {
                for r in 0..p+1 {
                    if q+r <= k {
                        dp[p+1][q+r] += dp[p][q];
                        dp[p+1][q+r] %= 1000000000 + 7;
                    }
                }
            }
        }

        return dp[n][k];
    }
}

fn main() {
    println!("{}", Solution::k_inverse_pairs(3, 0));
    println!("{}", Solution::k_inverse_pairs(3, 1));
    println!("{}", Solution::k_inverse_pairs(1000, 1000));
}


