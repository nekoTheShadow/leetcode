package main

import "fmt"

func zeroFilledSubarray(nums []int) int64 {
	x := int64(0)
	sum := int64(0)
	for _, num := range nums {
		if num == 0 {
			x++
		} else {
			sum += (1 + x) * x / 2
			x = 0
		}
	}

	sum += (1 + x) * x / 2
	return sum
}

func main() {
	fmt.Println(zeroFilledSubarray([]int{1, 3, 0, 0, 2, 0, 0, 4}))
	fmt.Println(zeroFilledSubarray([]int{0, 0, 0, 2, 0, 0}))
	fmt.Println(zeroFilledSubarray([]int{2, 10, 2019}))
}
