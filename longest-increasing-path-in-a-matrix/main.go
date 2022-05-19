package main

import "fmt"

func longestIncreasingPath(matrix [][]int) int {
	n := len(matrix)
	m := len(matrix[0])

	q := [][]int{}
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			q = append(q, []int{i, j})
		}
	}

	score := make([][]int, n)
	for i := 0; i < n; i++ {
		score[i] = make([]int, m)
		for j := 0; j < m; j++ {
			score[i][j] = 1
		}
	}

	diffs := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}

	for len(q) > 0 {
		cur := q[0]
		q = q[1:]

		x := cur[0]
		y := cur[1]
		for _, diff := range diffs {
			nx := x + diff[0]
			ny := y + diff[1]
			if 0 <= nx && nx < n && 0 <= ny && ny < m && matrix[x][y] < matrix[nx][ny] && score[nx][ny] < score[x][y]+1 {
				score[nx][ny] = score[x][y] + 1
				q = append(q, []int{nx, ny})
			}
		}
	}

	max := 0
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if max < score[i][j] {
				max = score[i][j]
			}
		}
	}
	return max
}

func main() {
	fmt.Println(longestIncreasingPath([][]int{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}))
	fmt.Println(longestIncreasingPath([][]int{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}))
	fmt.Println(longestIncreasingPath([][]int{{1}}))
}
