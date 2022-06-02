package main

import "fmt"

func transpose(matrix [][]int) [][]int {
	m := len(matrix)
	n := len(matrix[0])

	a := make([][]int, n)
	for i := 0; i < n; i++ {
		a[i] = make([]int, m)
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			a[j][i] = matrix[i][j]
		}
	}

	return a
}

func main() {
	fmt.Println(transpose([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}))
	fmt.Println(transpose([][]int{{1, 2, 3}, {4, 5, 6}}))
}
