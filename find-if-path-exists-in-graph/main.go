package main

import "fmt"

func validPath(n int, edges [][]int, source int, destination int) bool {
	g := make([][]int, n)
	for _, edge := range edges {
		g[edge[0]] = append(g[edge[0]], edge[1])
		g[edge[1]] = append(g[edge[1]], edge[0])
	}

	visited := make([]bool, n)
	que := []int{source}
	for len(que) > 0 {
		cur := que[0]
		que = que[1:]

		visited[cur] = true
		for _, nxt := range g[cur] {
			if !visited[nxt] {
				que = append(que, nxt)
			}
		}
	}

	return visited[destination]
}

func main() {
	fmt.Println(validPath(3, [][]int{{0, 1}, {1, 2}, {2, 0}}, 0, 2))
	fmt.Println(validPath(6, [][]int{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5))
}
