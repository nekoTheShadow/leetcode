package main

import "fmt"

func pivotArray(nums []int, pivot int) []int {
	a := []int{}
	b := []int{}
	c := []int{}
	for _, num := range nums {
		if num < pivot {
			a = append(a, num)
		} else if num == pivot {
			b = append(b, num)
		} else {
			c = append(c, num)
		}
	}

	for _, v := range b {
		a = append(a, v)
	}
	for _, v := range c {
		a = append(a, v)
	}
	return a
}

func main() {
	fmt.Println(pivotArray([]int{9, 12, 5, 10, 14, 3, 10}, 10)) //=> [9,5,3,10,10,12,14]
	fmt.Println(pivotArray([]int{-3, 4, 3, 2}, 2))              //=> [-3,2,4,3]
}
