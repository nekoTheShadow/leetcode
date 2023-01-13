package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(longestPath([]int{-1, 0, 0, 1, 1, 2}, "abacbe"))
	fmt.Println(longestPath([]int{-1, 0, 0, 0}, "aabc"))
}

func longestPath(parent []int, s string) int {
	n := len(parent)

	children = [][]int{}
	for i := 0; i < n; i++ {
		children = append(children, []int{})
	}
	for i := 1; i < n; i++ {
		children[parent[i]] = append(children[parent[i]], i)
	}

	S = s

	memo = []int{}
	for i := 0; i < n; i++ {
		memo = append(memo, -1)
	}

	max = -1
	for i := 0; i < n; i++ {
		dfs(i)
	}
	return max
}

var children [][]int
var S string
var memo []int
var max int

func dfs(cur int) int {
	if memo[cur] != -1 {
		return memo[cur]
	}

	sizes := []int{}
	for _, nxt := range children[cur] {
		if S[cur] != S[nxt] {
			sizes = append(sizes, dfs(nxt))
		}
	}

	n := len(sizes)
	sort.Ints(sizes)
	big1 := 0
	big2 := 0
	if n > 0 {
		big1 = sizes[n-1]
	}
	if n > 1 {
		big2 = sizes[n-2]
	}

	if max < big1+big2+1 {
		max = big1 + big2 + 1
	}

	memo[cur] = big1 + 1
	return big1 + 1
}
