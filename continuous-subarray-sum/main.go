package main

import "fmt"

func checkSubarraySum(nums []int, k int) bool {
	d := map[int]int{0: -1}
	sum := 0
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
		sum %= k

		if j, ok := d[sum]; ok {
			if i-j > 1 {
				return true
			}
		} else {
			d[sum] = i
		}
	}
	return false
}

func main() {
	fmt.Println(checkSubarraySum([]int{23, 2, 4, 6, 7}, 6))
	fmt.Println(checkSubarraySum([]int{23, 2, 6, 4, 7}, 6))
	fmt.Println(checkSubarraySum([]int{23, 2, 6, 4, 7}, 13))
}
