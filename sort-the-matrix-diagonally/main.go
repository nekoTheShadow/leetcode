package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(diagonalSort([][]int{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}}))
	fmt.Println(diagonalSort([][]int{{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}}))
}

func diagonalSort(mat [][]int) [][]int {
	m := len(mat)
	n := len(mat[0])

	for i := 0; i < m; i++ {
		arr := []int{}
		x := i
		y := 0
		for x < m && y < n {
			arr = append(arr, mat[x][y])
			x++
			y++
		}
		sort.Ints(arr)

		x = i
		y = 0
		for _, v := range arr {
			mat[x][y] = v
			x++
			y++
		}
	}

	for i := 0; i < n; i++ {
		arr := []int{}
		x := 0
		y := i
		for x < m && y < n {
			arr = append(arr, mat[x][y])
			x++
			y++
		}
		sort.Ints(arr)

		x = 0
		y = i
		for _, v := range arr {
			mat[x][y] = v
			x++
			y++
		}
	}

	return mat
}
