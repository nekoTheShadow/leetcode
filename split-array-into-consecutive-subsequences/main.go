package main

func isPossible(nums []int) bool {
	if len(nums) < 3 {
		return false
	}

	a := map[int]int{}
	b := map[int]int{}
	for _, num := range nums {
		if _, ok := a[num]; !ok {
			a[num] = 0
		}
		a[num]++
	}

	for _, num := range nums {
		if a[num] == 0 {
			continue
		}
		a[num]--

		if get(b, num-1) > 0 {
			b[num-1]--
			b[num]++
		} else if get(a, num+1) > 0 && get(a, num+2) > 0 {
			a[num+1]--
			a[num+2]--
			b[num+2]++
		} else {
			return false
		}
	}
	return true
}

func get(d map[int]int, k int) int {
	if v, ok := d[k]; ok {
		return v
	} else {
		return 0
	}
}
