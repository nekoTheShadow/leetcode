package main

import "fmt"

func findSmallestSetOfVertices(n int, edges [][]int) []int {
	income := make([]bool, n)
	for _, edge := range edges {
		income[edge[1]] = true
	}

	res := []int{}
	for i := 0; i < n; i++ {
		if !income[i] {
			res = append(res, i)
		}
	}
	return res
}

func main() {
	fmt.Println(findSmallestSetOfVertices(6, [][]int{{0, 1}, {0, 2}, {2, 5}, {3, 4}, {4, 2}}))
	fmt.Println(findSmallestSetOfVertices(5, [][]int{{0, 1}, {2, 1}, {3, 1}, {1, 4}, {2, 4}}))
}
