package main

func climbStairs(n int) int {
	dp := make([]int, n+1)
	dp[0] = 1
	for i := 0; i <= n; i++ {
		if i+1 <= n {
			dp[i+1] += dp[i]
		}
		if i+2 <= n {
			dp[i+2] += dp[i]
		}
	}
	return dp[n]
}
