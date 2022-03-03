package main

import (
	"fmt"
)

func numberOfArithmeticSlices(nums []int) int {
	if len(nums) < 3 {
		return 0
	}

	last := nums[1] - nums[0]
	size := 1
	ans := 0
	for i := 1; i < len(nums)-1; i++ {
		v := nums[i+1] - nums[i]
		if last == v {
			size++
		} else {
			ans += size * (size - 1) / 2
			last = v
			size = 1
		}
	}
	return ans + size*(size-1)/2
}

func main() {
	fmt.Println(numberOfArithmeticSlices([]int{1, 2, 3, 4}))
	fmt.Println(numberOfArithmeticSlices([]int{1}))
}
