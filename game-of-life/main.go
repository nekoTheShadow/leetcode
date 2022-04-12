package main

import "fmt"

func gameOfLife(board [][]int) {
	m := len(board)
	n := len(board[0])

	diffs := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			alive := 0
			for _, diff := range diffs {
				di := i + diff[0]
				dj := j + diff[1]
				if 0 <= di && di < m && 0 <= dj && dj < n && (board[di][dj]&1) != 0 {
					alive++
				}
			}

			if (board[i][j] & 1) == 0 {
				if alive == 3 {
					board[i][j] = board[i][j] | (1 << 1)
				}
			} else {
				if alive == 2 || alive == 3 {
					board[i][j] = board[i][j] | (1 << 1)
				}
			}
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if (board[i][j] & (1 << 1)) == 0 {
				board[i][j] = 0
			} else {
				board[i][j] = 1
			}
		}
	}
}

func main() {
	mat1 := [][]int{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}}
	gameOfLife(mat1)
	fmt.Println(mat1)

	mat2 := [][]int{{1, 1}, {1, 0}}
	gameOfLife(mat2)
	fmt.Println(mat2)
}
