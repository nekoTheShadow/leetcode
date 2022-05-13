package main

import "fmt"

func findUnsortedSubarray(nums []int) int {
	n := len(nums)

	a := make([]int, n)
	min := nums[n-1]
	for i := n - 1; i >= 0; i-- {
		if nums[i] < min {
			min = nums[i]
		}
		a[i] = min
	}

	b := make([]int, n)
	max := nums[0]
	for i := 0; i < n; i++ {
		if max < nums[i] {
			max = nums[i]
		}
		b[i] = max
	}

	x := 0
	for x < n && nums[x] <= a[x] {
		x++
	}
	y := n - 1
	for x < y && nums[y] >= b[y] {
		y--
	}
	return y - x + 1
}

func main() {
	fmt.Println(findUnsortedSubarray([]int{2, 6, 4, 8, 10, 9, 15}))
	fmt.Println(findUnsortedSubarray([]int{1, 2, 3, 4}))
	fmt.Println(findUnsortedSubarray([]int{1}))
}
