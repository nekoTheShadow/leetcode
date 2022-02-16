package main

import (
	"fmt"
	"sort"
)

func findFinalValue(nums []int, original int) int {
	sort.Ints(nums)
	for _, num := range nums {
		if num == original {
			original *= 2
		}
	}
	return original
}

func main() {
	fmt.Println(findFinalValue([]int{5, 3, 6, 1, 12}, 3)) //=> 24
	fmt.Println(findFinalValue([]int{2, 7, 9}, 4))        //=> 4
}
