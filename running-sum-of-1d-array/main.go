package main

import "fmt"

func runningSum(nums []int) []int {
	n := len(nums)
	a := make([]int, n)
	a[0] = nums[0]
	for i := 1; i < n; i++ {
		a[i] = a[i-1] + nums[i]
	}
	return a
}

func main() {
	fmt.Println(runningSum([]int{1, 2, 3, 4}))
	fmt.Println(runningSum([]int{1, 1, 1, 1, 1}))
	fmt.Println(runningSum([]int{3, 1, 2, 10, 1}))
}
