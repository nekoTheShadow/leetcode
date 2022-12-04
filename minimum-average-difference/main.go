package main

import (
	"fmt"
	"math"
)

func minimumAverageDifference(nums []int) int {
	l := 0
	r := 0
	for _, num := range nums {
		r += num
	}

	n := len(nums)
	minAvg := math.MaxInt
	minI := -1
	for i := 0; i < n; i++ {
		l += nums[i]
		r -= nums[i]

		var avg int
		if n-i-1 > 0 {
			avg = l/(i+1) - r/(n-i-1)
		} else {
			avg = l / (i + 1)
		}

		if avg < 0 {
			avg = -avg
		}

		if avg < minAvg {
			minAvg = avg
			minI = i
		}
	}
	return minI
}

func main() {
	fmt.Println(minimumAverageDifference([]int{2, 5, 3, 9, 5, 3}))
	fmt.Println(minimumAverageDifference([]int{0}))
}
