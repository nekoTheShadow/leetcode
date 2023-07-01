package main

import (
	"fmt"
	"math"
)

func distributeCookies(cookies []int, k int) int {
	return dfs(cookies, k, 0, make([]int, k))
}

func dfs(cookies []int, k int, x int, totals []int) int {
	if x == len(cookies) {
		max := math.MinInt
		for _, v := range totals {
			if max < v {
				max = v
			}
		}
		return max
	}

	min := math.MaxInt
	for i := 0; i < k; i++ {
		totals[i] += cookies[x]
		v := dfs(cookies, k, x+1, totals)
		if v < min {
			min = v
		}
		totals[i] -= cookies[x]
	}
	return min
}

func main() {
	fmt.Println(distributeCookies([]int{8, 15, 10, 20, 8}, 2))
	fmt.Println(distributeCookies([]int{6, 1, 3, 2, 2, 4, 1, 2}, 3))
	fmt.Println(distributeCookies([]int{6265, 7826, 16834, 63341, 68901, 58882, 50651, 75609}, 8))
}
