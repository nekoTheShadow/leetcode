package main

import "fmt"

var tree [][]int
var res []int
var count []int
var N int

func sumOfDistancesInTree(n int, edges [][]int) []int {
	N = n
	tree = make([][]int, n)
	res = make([]int, n)
	count = make([]int, n)
	for _, edge := range edges {
		tree[edge[0]] = append(tree[edge[0]], edge[1])
		tree[edge[1]] = append(tree[edge[1]], edge[0])
	}
	dfs1(0, -1)
	dfs2(0, -1)
	return res
}

func dfs1(root, pre int) {
	for _, nxt := range tree[root] {
		if nxt == pre {
			continue
		}
		dfs1(nxt, root)
		count[root] += count[nxt]
		res[root] += res[nxt] + count[nxt]
	}
	count[root]++
}

func dfs2(root, pre int) {
	for _, nxt := range tree[root] {
		if nxt == pre {
			continue
		}
		res[nxt] = res[root] - count[nxt] + N - count[nxt]
		dfs2(nxt, root)
	}
}

func main() {
	fmt.Println(sumOfDistancesInTree(6, [][]int{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}}))
	fmt.Println(sumOfDistancesInTree(1, [][]int{}))
	fmt.Println(sumOfDistancesInTree(2, [][]int{{1, 0}}))
}
