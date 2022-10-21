package main

import "fmt"

func containsNearbyDuplicate(nums []int, k int) bool {
	s := map[int]bool{}
	for i := 0; i < len(nums); i++ {
		if _, ok := s[nums[i]]; ok {
			return true
		}
		s[nums[i]] = true
		if i-k >= 0 {
			delete(s, nums[i-k])
		}
	}
	return false
}

func main() {
	fmt.Println(containsNearbyDuplicate([]int{1, 2, 3, 1}, 3))
	fmt.Println(containsNearbyDuplicate([]int{1, 0, 1, 1}, 1))
	fmt.Println(containsNearbyDuplicate([]int{1, 2, 3, 1, 2, 3}, 2))
	fmt.Println(containsNearbyDuplicate([]int{1, 2, 1}, 0))
}
