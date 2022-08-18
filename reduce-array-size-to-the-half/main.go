package main

import (
	"fmt"
	"sort"
)

func minSetSize(arr []int) int {
	d := map[int]int{}
	for _, v := range arr {
		if _, ok := d[v]; !ok {
			d[v] = 0
		}
		d[v]++
	}

	counts := []int{}
	for _, count := range d {
		counts = append(counts, count)
	}
	sort.Ints(counts)

	ans := 0
	sum := 0
	for i := len(counts) - 1; i >= 0; i-- {
		if len(arr)/2 <= sum {
			break
		}
		ans++
		sum += counts[i]
	}
	return ans
}

func main() {
	fmt.Println(minSetSize([]int{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}))
	fmt.Println(minSetSize([]int{7, 7, 7, 7, 7, 7}))
}
