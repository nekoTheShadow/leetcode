package main

import "sort"

func findOriginalArray(changed []int) []int {
	n := len(changed)
	if n%2 != 0 {
		return []int{}
	}

	counter := map[int]int{}
	for _, x := range changed {
		if _, ok := counter[x]; !ok {
			counter[x] = 0
		}
		counter[x]++
	}

	sort.Ints(changed)
	ans := []int{}
	for _, x := range changed {
		y := x * 2
		if x == y {
			count, ok := counter[x]
			if ok && count > 1 {
				ans = append(ans, x)
				counter[x] -= 2
			}
		} else {
			count1, ok1 := counter[x]
			count2, ok2 := counter[y]
			if ok1 && count1 > 0 && ok2 && count2 > 0 {
				ans = append(ans, x)
				counter[x]--
				counter[y]--
			}
		}
	}

	if len(ans) == n/2 {
		return ans
	} else {
		return []int{}
	}
}
