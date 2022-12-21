package main

import "fmt"

func possibleBipartition(n int, dislikes [][]int) bool {
	edges := make([][]int, n)
	for _, dislike := range dislikes {
		edges[dislike[0]-1] = append(edges[dislike[0]-1], dislike[1]-1)
		edges[dislike[1]-1] = append(edges[dislike[1]-1], dislike[0]-1)
	}

	color := make([]int, n)
	for i := 0; i < n; i++ {
		color[i] = -1
	}

	for start := 0; start < n; start++ {
		if color[start] != -1 {
			continue
		}

		que := []int{start}
		for len(que) > 0 {
			cur := que[0]
			que = que[1:]

			for _, nxt := range edges[cur] {
				if color[nxt] == -1 {
					color[nxt] = 1 - color[cur]
					que = append(que, nxt)
				} else {
					if color[cur] == color[nxt] {
						return false
					}
				}
			}
		}
	}

	return true
}

func main() {
	fmt.Println(possibleBipartition(4, [][]int{{1, 2}, {1, 3}, {2, 4}}))
	fmt.Println(possibleBipartition(3, [][]int{{1, 2}, {1, 3}, {2, 3}}))
	fmt.Println(possibleBipartition(5, [][]int{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}))
}
