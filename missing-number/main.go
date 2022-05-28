package main

import "fmt"

func missingNumber(nums []int) int {
	sum := 0
	for _, num := range nums {
		sum += num
	}
	n := len(nums)
	return n*(n+1)/2 - sum
}

func main() {
	fmt.Println(missingNumber([]int{3, 0, 1}))
	fmt.Println(missingNumber([]int{0, 1}))
	fmt.Println(missingNumber([]int{9, 6, 4, 2, 3, 5, 7, 0, 1}))
}
