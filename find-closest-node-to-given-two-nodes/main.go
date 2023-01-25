package main

import (
	"fmt"
	"math"
)

func closestMeetingNode(edges []int, node1 int, node2 int) int {
	n := len(edges)

	dist1 := []int{}
	dist2 := []int{}
	for i := 0; i < n; i++ {
		dist1 = append(dist1, INF)
		dist2 = append(dist2, INF)
	}
	dist1[node1] = 0
	dist2[node2] = 0

	EDGES = edges
	dfs(node1, &dist1)
	dfs(node2, &dist2)

	minScore := INF
	minIndex := -1
	for i := n - 1; i >= 0; i-- {
		if dist1[i] == INF || dist2[i] == INF {
			continue
		}

		var v int
		if dist1[i] < dist2[i] {
			v = dist2[i]
		} else {
			v = dist1[i]
		}

		if v <= minScore {
			minScore = v
			minIndex = i
		}
	}

	return minIndex
}

const INF = math.MaxInt / 2

var EDGES []int

func dfs(start int, dist *[]int) {
	if EDGES[start] == -1 {
		return
	}

	if (*dist)[start]+1 < (*dist)[EDGES[start]] {
		(*dist)[EDGES[start]] = (*dist)[start] + 1
		dfs(EDGES[start], dist)
	}
}

func main() {
	fmt.Println(closestMeetingNode([]int{2, 2, 3, -1}, 0, 1))
	fmt.Println(closestMeetingNode([]int{1, 2, -1}, 0, 2))
	fmt.Println(closestMeetingNode([]int{4, 4, 8, -1, 9, 8, 4, 4, 1, 1}, 5, 6))
}
