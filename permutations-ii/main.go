package main

import "fmt"

var N int
var A []int

func permuteUnique(nums []int) [][]int {
	N = len(nums)
	A = nums
	return solve(0)
}

func solve(bit int) [][]int {
	if bit == (1<<N)-1 {
		return [][]int{{}}
	}

	used := map[int]bool{}
	res := [][]int{}
	for i := 0; i < N; i++ {
		if (bit & (1 << i)) != 0 {
			continue
		}
		if _, ok := used[A[i]]; ok {
			continue
		}

		for _, b := range solve(bit | (1 << i)) {
			res = append(res, append(b, A[i]))
		}
		used[A[i]] = true
	}

	return res
}

func main() {
	fmt.Println(permuteUnique([]int{1, 1, 2}))
	fmt.Println(permuteUnique([]int{1, 2, 3}))
}
