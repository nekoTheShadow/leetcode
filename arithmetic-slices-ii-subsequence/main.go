package main

import "fmt"

func numberOfArithmeticSlices(nums []int) int {
	total := 0
	dp := []map[int]int{}
	for i := 0; i < len(nums); i++ {
		dp = append(dp, map[int]int{})
	}
	for i := 0; i < len(nums); i++ {
		for j := 0; j < i; j++ {
			diff := nums[j] - nums[i]
			dp[i][diff] += dp[j][diff] + 1
			total += dp[j][diff]
		}
	}
	return total
}

func main() {
	fmt.Println(numberOfArithmeticSlices([]int{2, 4, 6, 8, 10}))
	fmt.Println(numberOfArithmeticSlices([]int{7, 7, 7, 7, 7}))
}
