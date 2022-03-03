package main

import "fmt"

func countPairs(nums []int, k int) int {
	c := 0
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			if nums[i] == nums[j] && (i*j)%k == 0 {
				c++
			}
		}
	}
	return c
}

func main() {
	fmt.Println(countPairs([]int{3, 1, 2, 2, 2, 1, 3}, 2))
	fmt.Println(countPairs([]int{1, 2, 3, 4}, 1))
}
