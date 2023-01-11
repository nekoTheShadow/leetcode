package main

import "fmt"

func main() {
	fmt.Println(minTime(7, [][]int{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, []bool{false, false, true, false, true, true, false}))
	fmt.Println(minTime(7, [][]int{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, []bool{false, false, true, false, false, true, false}))
	fmt.Println(minTime(7, [][]int{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, []bool{false, false, false, false, false, false, false}))
}

func minTime(n int, edges [][]int, hasApple []bool) int {
	tree = make([][]int, n)
	for i := 0; i < n; i++ {
		tree[i] = []int{}
	}
	for _, edge := range edges {
		tree[edge[0]] = append(tree[edge[0]], edge[1])
		tree[edge[1]] = append(tree[edge[1]], edge[0])
	}
	HasApple = hasApple

	ans := dfs(0, -1) - 2
	if ans > 0 {
		return ans
	} else {
		return 0
	}
}

var tree [][]int
var HasApple []bool

func dfs(cur int, prev int) int {
	ret := 0
	for _, nxt := range tree[cur] {
		if nxt != prev {
			ret += dfs(nxt, cur)
		}
	}

	if ret > 0 || HasApple[cur] {
		return ret + 2
	} else {
		return ret
	}
}
