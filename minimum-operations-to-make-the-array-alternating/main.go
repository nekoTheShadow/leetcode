package main

import (
	"fmt"
	"sort"
)

func minimumOperations(nums []int) int {
	if len(nums) == 1 {
		return 0
	}

	c1 := 0
	c2 := 0
	d1 := map[int]int{0: 0}
	d2 := map[int]int{0: 0}
	for i, num := range nums {
		if i%2 == 0 {
			c1++
			if _, ok := d1[num]; !ok {
				d1[num] = 0
			}
			d1[num]++
		} else {
			c2++
			if _, ok := d2[num]; !ok {
				d2[num] = 0
			}
			d2[num]++
		}
	}

	r2 := map[int]map[int]bool{}
	for k, v := range d2 {
		if _, ok := r2[v]; !ok {
			r2[v] = map[int]bool{}
		}
		r2[v][k] = true
	}

	keys := []int{}
	for key := range r2 {
		keys = append(keys, key)
	}
	sort.Slice(keys, func(i, j int) bool { return keys[i] > keys[j] })

	ans := 9999999
	for k1, v1 := range d1 {
		var x int
		if _, ok := r2[keys[0]][k1]; ok && len(r2[keys[0]]) == 1 {
			x = (c1 - v1) + (c2 - keys[1])
		} else {
			x = (c1 - v1) + (c2 - keys[0])
		}
		if x < ans {
			ans = x
		}
	}
	return ans
}

func main() {
	fmt.Println(minimumOperations([]int{3, 1, 3, 2, 4, 3}))
	fmt.Println(minimumOperations([]int{1, 2, 2, 2, 2}))
}
