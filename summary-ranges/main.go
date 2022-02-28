package main

import "fmt"

func main() {
	fmt.Println(summaryRanges([]int{0, 1, 2, 4, 5, 7}))
	fmt.Println(summaryRanges([]int{0, 2, 3, 4, 6, 8, 9}))
}

func summaryRanges(nums []int) []string {
	if len(nums) == 0 {
		return []string{}
	}

	rngs := [][]int{{nums[0]}}
	for i := 1; i < len(nums); i++ {
		rng := rngs[len(rngs)-1]
		if rng[len(rng)-1]+1 == nums[i] {
			rngs[len(rngs)-1] = append(rngs[len(rngs)-1], nums[i])
		} else {
			rngs = append(rngs, []int{nums[i]})
		}
	}

	ans := []string{}
	for _, rng := range rngs {
		if len(rng) == 1 {
			ans = append(ans, fmt.Sprint(rng[0]))
		} else {
			ans = append(ans, fmt.Sprintf("%v->%v", rng[0], rng[len(rng)-1]))
		}
	}
	return ans
}
