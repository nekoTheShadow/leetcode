package main

import "fmt"

func twoSum(nums []int, target int) []int {
	idxs := map[int]int{}
	for i := 0; i < len(nums); i++ {
		idxs[nums[i]] = i
	}

	for i := 0; i < len(nums); i++ {
		if j, ok := idxs[target-nums[i]]; ok && i != j {
			return []int{i, j}
		}
	}

	panic(fmt.Sprintf("Unexpected: nums=`%v` target=`%v`", nums, target))
}
