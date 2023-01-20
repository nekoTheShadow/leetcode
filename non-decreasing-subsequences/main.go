package main

import "fmt"

func findSubsequences(nums []int) [][]int {
	NUMS = nums
	A = []int{}
	B = map[string][]int{}

	for i := 0; i < len(nums); i++ {
		dfs(i)
	}

	vals := [][]int{}
	for _, val := range B {
		vals = append(vals, val)
	}
	return vals
}

var NUMS []int
var A []int
var B map[string][]int

func dfs(i int) {
	A = append(A, NUMS[i])

	key := fmt.Sprintf("%v", A)
	if _, ok := B[key]; ok {
		A = A[:len(A)-1]
		return
	}

	if len(A) > 1 {
		B[key] = append([]int{}, A...)
	}

	for j := i + 1; j < len(NUMS); j++ {
		if NUMS[i] <= NUMS[j] {
			dfs(j)
		}
	}
	A = A[:len(A)-1]
}

func main() {
	fmt.Println(findSubsequences([]int{4, 6, 7, 7}))
}
