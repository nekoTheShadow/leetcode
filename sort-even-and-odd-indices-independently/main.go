package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(sortEvenOdd([]int{4, 1, 2, 3}))
	fmt.Println(sortEvenOdd([]int{2, 1}))
}

func sortEvenOdd(nums []int) []int {
	a := []int{}
	b := []int{}
	for i := 0; i < len(nums); i++ {
		if i%2 == 0 {
			a = append(a, nums[i])
		} else {
			b = append(b, nums[i])
		}
	}

	sort.Ints(a)
	sort.Slice(b, func(i, j int) bool { return b[i] > b[j] })

	for i := 0; i < len(nums); i++ {
		if i%2 == 0 {
			nums[i] = a[i/2]
		} else {
			nums[i] = b[i/2]
		}
	}

	return nums
}
