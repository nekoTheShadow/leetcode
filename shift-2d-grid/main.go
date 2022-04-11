package main

import "fmt"

func shiftGrid(grid [][]int, k int) [][]int {
	m := len(grid)
	n := len(grid[0])

	ans := make([][]int, m)
	for i := 0; i < m; i++ {
		ans[i] = make([]int, n)
	}

	k %= (m * n)
	if k == 0 {
		k = m * n
	}

	cur := (m * n) - k
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			ans[i][j] = grid[cur/n][cur%n]
			cur = (cur + 1) % (m * n)
		}
	}

	return ans
}

func main() {
	fmt.Println(shiftGrid([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1))
	fmt.Println(shiftGrid([][]int{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}}, 4))
	fmt.Println(shiftGrid([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 9))
	fmt.Println(shiftGrid([][]int{{1}}, 100))
}
