package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(kthSmallest([][]int{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8))
	fmt.Println(kthSmallest([][]int{{-5}}, 1))
}

func kthSmallest(matrix [][]int, k int) int {
	n := len(matrix)
	ptr := make([]int, n)

	a := []int{}
	for i := 0; i < n*n; i++ {
		minVal := math.MaxInt
		minX := -1
		for x := 0; x < n; x++ {
			if ptr[x] < n && matrix[x][ptr[x]] < minVal {
				minVal = matrix[x][ptr[x]]
				minX = x
			}
		}
		a = append(a, matrix[minX][ptr[minX]])
		ptr[minX]++
	}

	return a[k-1]
}
