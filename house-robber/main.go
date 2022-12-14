package main

import "fmt"

func rob(nums []int) int {
	n := len(nums)
	dp := make([][]int, n+1)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 2)
	}

	for i := 0; i < n; i++ {
		dp[i+1][0] = Max(dp[i][0], dp[i][1])
		dp[i+1][1] = nums[i] + dp[i][0]
	}
	return Max(dp[n][0], dp[n][1])
}

func Max(a ...int) int {
	max := a[0]
	for i := 1; i < len(a); i++ {
		if max < a[i] {
			max = a[i]
		}
	}
	return max
}

func main() {
	fmt.Println(rob([]int{1, 2, 3, 1}))
	fmt.Println(rob([]int{2, 7, 9, 3, 1}))
}
