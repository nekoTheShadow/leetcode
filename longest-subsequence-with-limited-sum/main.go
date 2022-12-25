package main

import (
	"fmt"
	"sort"
)

func answerQueries(nums []int, queries []int) []int {
	sort.Ints(nums)
	for i := 1; i < len(nums); i++ {
		nums[i] += nums[i-1]
	}
	ans := []int{}
	for _, query := range queries {
		x := sort.Search(len(nums), func(i int) bool { return nums[i] > query })
		ans = append(ans, x)
	}
	return ans
}

func main() {
	fmt.Println(answerQueries([]int{4, 5, 2, 1}, []int{3, 10, 21}))
	fmt.Println(answerQueries([]int{2, 3, 4, 5}, []int{1}))
}
