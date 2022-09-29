package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(findClosestElements([]int{1, 2, 3, 4, 5}, 4, 3))
	fmt.Println(findClosestElements([]int{1, 2, 3, 4, 5}, 4, -1))
}

func findClosestElements(arr []int, k int, x int) []int {
	sort.Slice(arr, func(i, j int) bool {
		return Abs(arr[i]-x) < Abs(arr[j]-x) || (Abs(arr[i]-x) == Abs(arr[j]-x) && arr[i] < arr[j])
	})

	sort.Ints(arr[0:k])
	return arr[0:k]
}

func Abs(x int) int {
	if x > 0 {
		return x
	} else {
		return -x
	}
}
