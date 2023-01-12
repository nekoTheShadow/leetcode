package main

import (
	"fmt"
)

func main() {
	fmt.Println(countSubTrees(7, [][]int{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd"))
	fmt.Println(countSubTrees(4, [][]int{{0, 1}, {1, 2}, {0, 3}}, "bbbb"))
	fmt.Println(countSubTrees(5, [][]int{{0, 1}, {0, 2}, {1, 3}, {0, 4}}, "aabab"))
}

func countSubTrees(n int, edges [][]int, labels string) []int {
	tree := [][]int{}
	for i := 0; i < n; i++ {
		tree = append(tree, []int{})
	}
	for _, edge := range edges {
		tree[edge[0]] = append(tree[edge[0]], edge[1])
		tree[edge[1]] = append(tree[edge[1]], edge[0])
	}

	N = n
	TREE = tree
	LABELS = []rune(labels)
	ANS = make([]int, n)
	MEMO = map[int]map[rune]int{}
	run(0, -1)

	return ANS
}

func run(cur int, prev int) {
	ANS[cur] = dfs(cur, prev)[LABELS[cur]]
	for _, nxt := range TREE[cur] {
		if nxt != prev {
			run(nxt, cur)
		}
	}
}

var N int
var TREE [][]int
var LABELS []rune
var ANS []int
var MEMO map[int]map[rune]int

func dfs(cur int, prev int) map[rune]int {
	if _, ok := MEMO[cur]; ok {
		return MEMO[cur]
	}

	x := map[rune]int{}
	for _, key := range "abcdefghijklmnopqrstuvwxyz" {
		x[key] = 0
	}
	x[LABELS[cur]] = 1

	for _, nxt := range TREE[cur] {
		if nxt != prev {
			y := dfs(nxt, cur)
			for _, key := range "abcdefghijklmnopqrstuvwxyz" {
				x[key] += y[key]
			}
		}
	}

	MEMO[cur] = x
	return x
}
