package main

import (
	"math"
)

func minOperations(nums []int) int {
	counter := map[int]int{}
	n := 0
	for _, num := range nums {
		if _, ok := counter[num]; !ok {
			counter[num] = 0
		}
		counter[num]++
		n = Max(n, counter[num])
	}

	dp := make([]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = math.MaxInt
	}
	dp[0] = 0
	if 2 <= n {
		dp[2] = 1
	}
	if 3 <= n {
		dp[3] = 1
	}
	for i := 2; i <= n; i++ {
		if i+2 <= n {
			dp[i+2] = Min(dp[i+2], dp[i]+1)
		}
		if i+3 <= n {
			dp[i+3] = Min(dp[i+3], dp[i]+1)
		}
	}

	ret := 0
	for _, v := range counter {
		if v == 1 {
			return -1
		}
		ret += dp[v]
	}
	return ret
}

func Min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}

func Max(a, b int) int {
	if a < b {
		return b
	} else {
		return a
	}
}
