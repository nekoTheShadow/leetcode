package main

import "fmt"

var colors []int
var g [][]int

func dfs(cur int, color int) bool {
	colors[cur] = color
	for _, nxt := range g[cur] {
		if colors[nxt] == color || (colors[nxt] == 0 && !dfs(nxt, -color)) {
			return false
		}
	}
	return true
}

func isBipartite(graph [][]int) bool {
	g = graph
	colors = make([]int, len(graph))

	for cur := 0; cur < len(graph); cur++ {
		if colors[cur] == 0 && !dfs(cur, 1) {
			return false
		}
	}

	return true
}

func main() {
	fmt.Println(isBipartite([][]int{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}))
	fmt.Println(isBipartite([][]int{{1, 3}, {0, 2}, {1, 3}, {0, 2}}))
}
