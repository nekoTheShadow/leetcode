package main

import "fmt"

func countElements(nums []int) int {
	ans := 0
	for _, x := range nums {
		small := false
		great := false
		for _, y := range nums {
			if x < y {
				great = true
			}
			if x > y {
				small = true
			}
		}
		if small && great {
			ans++
		}
	}
	return ans
}

func main() {
	fmt.Println(countElements([]int{11, 7, 2, 15}))
	fmt.Println(countElements([]int{-3, 3, 3, 90}))
}
