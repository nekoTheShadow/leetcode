package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(shortestPathBinaryMatrix([][]int{{0, 1}, {1, 0}}))
	fmt.Println(shortestPathBinaryMatrix([][]int{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}))
	fmt.Println(shortestPathBinaryMatrix([][]int{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}))
}

func shortestPathBinaryMatrix(grid [][]int) int {
	if grid[0][0] == 1 {
		return -1
	}

	n := len(grid)
	inf := math.MaxInt/2 - 1

	score := make([][]int, n)
	for i := 0; i < n; i++ {
		score[i] = make([]int, n)
		for j := 0; j < n; j++ {
			score[i][j] = inf
		}
	}
	score[0][0] = 1

	q := [][]int{{0, 0}}
	for len(q) > 0 {
		cur := q[0]
		q = q[1:]
		x := cur[0]
		y := cur[1]
		for dx := -1; dx <= 1; dx++ {
			for dy := -1; dy <= 1; dy++ {
				nx := x + dx
				ny := y + dy
				if 0 <= nx && nx < n && 0 <= ny && ny < n && grid[nx][ny] == 0 && score[x][y]+1 < score[nx][ny] {
					score[nx][ny] = score[x][y] + 1
					q = append(q, []int{nx, ny})
				}
			}
		}
	}

	ans := score[n-1][n-1]
	if ans == inf {
		return -1
	} else {
		return ans
	}
}

// const INF = math.MaxInt/2 - 1

// type Solver struct {
// 	grid  [][]int
// 	score [][]int
// 	n     int
// }

// func NewSolver(grid [][]int) *Solver {
// 	return &Solver{
// 		grid: grid,
// 		n:    len(grid),
// 	}
// }

// func (s *Solver) Solve() int {
// 	if s.grid[0][0] == 1 {
// 		return -1
// 	}

// 	score := make([][]int, s.n)
// 	for i := 0; i < s.n; i++ {
// 		score[i] = make([]int, s.n)
// 		for j := 0; j < s.n; j++ {
// 			score[i][j] = INF
// 		}
// 	}
// 	score[0][0] = 1

// 	q := [][]int{{0, 0}}
// 	for len(q) > 0 {

// 	}

// 	s.dfs(0, 0)
// 	ans := s.score[s.n-1][s.n-1]
// 	if ans == INF {
// 		return -1
// 	} else {
// 		return ans
// 	}
// }

// func (s *Solver) dfs(x, y int) {
// 	for dx := -1; dx <= 1; dx++ {
// 		for dy := -1; dy <= 1; dy++ {
// 			nx := x + dx
// 			ny := y + dy
// 			if 0 <= nx && nx < s.n && 0 <= ny && ny < s.n && s.grid[nx][ny] == 0 && s.score[x][y]+1 < s.score[nx][ny] {
// 				s.score[nx][ny] = s.score[x][y] + 1
// 				s.dfs(nx, ny)
// 			}
// 		}
// 	}
// }
