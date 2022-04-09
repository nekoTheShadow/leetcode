package main

import (
	"fmt"
	"sort"
)

func topKFrequent_bucketsort(nums []int, k int) []int {
	c := map[int]int{}
	for _, num := range nums {
		if _, ok := c[num]; !ok {
			c[num] = 0
		}
		c[num]++
	}

	max := -1
	for _, count := range c {
		if max < count {
			max = count
		}
	}

	mat := [][]int{}
	for i := 0; i <= max; i++ {
		mat = append(mat, []int{})
	}

	for num, count := range c {
		mat[count] = append(mat[count], num)
	}

	ans := []int{}
	for i := max; i >= 0; i-- {
		if len(ans) >= k {
			break
		}
		ans = append(ans, mat[i]...)
	}
	return ans[:k]
}

func topKFrequent(nums []int, k int) []int {
	c := map[int]int{}
	for _, num := range nums {
		if _, ok := c[num]; !ok {
			c[num] = 0
		}
		c[num]++
	}

	type Tuple struct {
		count int
		value int
	}

	tpls := []*Tuple{}
	for value, count := range c {
		tpls = append(tpls, &Tuple{count: count, value: value})
	}
	sort.Slice(tpls, func(i, j int) bool { return tpls[i].count > tpls[j].count })

	ans := []int{}
	for i := 0; i < k; i++ {
		ans = append(ans, tpls[i].value)
	}
	return ans
}

func main() {
	fmt.Println(topKFrequent([]int{1, 1, 1, 2, 2, 3}, 2))
	fmt.Println(topKFrequent([]int{1}, 1))
	fmt.Println(topKFrequent([]int{1, 2}, 2))
}
