package main

import "fmt"

func singleNonDuplicate(nums []int) int {
	ng := -1
	ok := len(nums)

	for Abs(ng-ok) > 1 {
		mi := (ok + ng) / 2
		if Get(nums, mi) == Get(nums, mi^1) {
			ng = mi
		} else {
			ok = mi
		}
	}
	return nums[ok]
}

func Abs(x int) int {
	if x > 0 {
		return x
	} else {
		return -x
	}
}

func Get(a []int, i int) int {
	if i < len(a) {
		return a[i]
	} else {
		return -1
	}
}

func main() {
	fmt.Println(singleNonDuplicate([]int{1, 1, 2, 3, 3, 4, 4, 8, 8}))
	fmt.Println(singleNonDuplicate([]int{3, 3, 7, 7, 10, 11, 11}))
}
