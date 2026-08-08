package main

import "slices"

func findMissingElements(nums []int) []int {
	min := slices.Min(nums)
	max := slices.Max(nums)

	ans := []int{}
	for x := min; x < max; x++ {
		if !slices.Contains(nums, x) {
			ans = append(ans, x)
		}
	}
	return ans
}
