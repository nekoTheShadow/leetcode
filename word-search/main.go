package main

import "fmt"

func exist(board [][]byte, word string) bool {
	BOARD = board
	WORD = word

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			if board[i][j] == word[0] {
				BOARD[i][j] = '*'
				if dfs(i, j, 1) {
					return true
				}
				BOARD[i][j] = word[0]
			}
		}
	}

	return false
}

var BOARD [][]byte
var WORD string

func dfs(x, y, p int) bool {
	if p == len(WORD) {
		return true
	}

	for _, diff := range [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}} {
		nx := x + diff[0]
		ny := y + diff[1]

		if 0 <= nx && nx < len(BOARD) && 0 <= ny && ny < len(BOARD[0]) && BOARD[nx][ny] == WORD[p] {
			BOARD[nx][ny] = '*'
			if dfs(nx, ny, p+1) {
				return true
			}
			BOARD[nx][ny] = WORD[p]
		}
	}
	return false
}

func main() {
	fmt.Println(exist([][]byte{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"))
	fmt.Println(exist([][]byte{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"))
	fmt.Println(exist([][]byte{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"))
}
