package main

import (
	"fmt"
	"math"
	"sort"
)

func maxSatisfaction(satisfaction []int) int {
	sort.Ints(satisfaction)

	n := len(satisfaction)
	dp := make([][]int, n+1)

	for i := 0; i <= n; i++ {
		dp[i] = make([]int, n+1)
		for j := 0; j <= n; j++ {
			dp[i][j] = math.MinInt
		}
	}
	dp[0][0] = 0

	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if dp[i][j] != math.MinInt {
				dp[i+1][j] = Max(dp[i+1][j], dp[i][j])                           // 何もしない
				dp[i+1][j+1] = Max(dp[i+1][j+1], dp[i][j]+satisfaction[i]*(j+1)) // 採用する
			}
		}
	}

	ans := math.MinInt
	for i := 0; i <= n; i++ {
		ans = Max(ans, dp[n][i])
	}

	return ans
}

func Max(a, b int) int {
	if a < b {
		return b
	} else {
		return a
	}
}

func main() {
	fmt.Println(maxSatisfaction([]int{-1, -8, 0, 5, -9}))
	fmt.Println(maxSatisfaction([]int{4, 3, 2}))
	fmt.Println(maxSatisfaction([]int{-1, -4, -5}))
}
