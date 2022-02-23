package main

import (
	"fmt"
	"sort"
)

func minimumRemoval(beans []int) int64 {
	sort.Ints(beans)
	sum := 0
	for _, bean := range beans {
		sum += bean
	}

	l := 0
	r := sum
	ans := sum
	for i, bean := range beans {
		x := l + (r - (len(beans)-i)*bean)
		if x < ans {
			ans = x
		}
		l += bean
		r -= bean
	}
	return int64(ans)
}

func main() {
	fmt.Println(minimumRemoval([]int{4, 1, 6, 5}))
	fmt.Println(minimumRemoval([]int{2, 10, 3, 2}))
}
