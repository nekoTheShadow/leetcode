package main

import "fmt"

func deleteAndEarn(nums []int) int {
	n := 10000

	c := make([]int, n+1)
	for _, num := range nums {
		c[num]++
	}

	dp := make([]int, n+1)
	dp[1] = c[1]
	for i := 2; i <= n; i++ {
		dp[i] = Max(dp[i-1], dp[i-2]+i*c[i])
	}
	return dp[n]
}

func Max(a int, b ...int) int {
	for _, v := range b {
		if a < v {
			a = v
		}
	}
	return a
}

func main() {
	fmt.Println(deleteAndEarn([]int{3, 4, 2}))
	fmt.Println(deleteAndEarn([]int{2, 2, 3, 3, 3, 4}))
}
