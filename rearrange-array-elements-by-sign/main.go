package main

import "fmt"

func rearrangeArray(nums []int) []int {
	a := make([]int, len(nums))
	i := 0
	j := 1
	for _, x := range nums {
		if x > 0 {
			a[i] = x
			i += 2
		} else {
			a[j] = x
			j += 2
		}
	}
	return a
}

func main() {
	fmt.Println(rearrangeArray([]int{3, 1, -2, -5, 2, -4})) //=> 3,-2,1,-5,2,-4
	fmt.Println(rearrangeArray([]int{-1, 1}))               //=> 1,-1
}
