package main

import (
	"fmt"
	"sort"
)

func lengthOfLIS(nums []int) int {
	a := []int{}
	for _, num := range nums {
		j := sort.Search(len(a), func(i int) bool {
			return a[i] >= num
		})
		if j != -1 && j < len(a) {
			a[j] = num
		} else {
			a = append(a, num)
		}
	}
	return len(a)
}

func main() {
	fmt.Println(lengthOfLIS([]int{10, 9, 2, 5, 3, 7, 101, 18}))
	fmt.Println(lengthOfLIS([]int{0, 1, 0, 3, 2, 3}))
	fmt.Println(lengthOfLIS([]int{7, 7, 7, 7, 7, 7, 7}))
}
