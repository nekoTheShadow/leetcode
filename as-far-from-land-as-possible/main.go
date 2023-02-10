package main

import (
	"fmt"
	"math"
)

func maxDistance(grid [][]int) int {
	has0 := false
	has1 := false
	for _, row := range grid {
		for _, v := range row {
			if v == 0 {
				has0 = true
			} else {
				has1 = true
			}
		}
	}

	if !(has0 && has1) {
		return -1
	}

	GRID = grid
	N = len(grid)
	COST = make([][]int, N)
	for i := 0; i < N; i++ {
		COST[i] = make([]int, N)
	}

	for i := 0; i < N; i++ {
		for j := 0; j < N; j++ {
			if GRID[i][j] == 0 {
				COST[i][j] = math.MaxInt
			} else {
				COST[i][j] = 0
			}
		}
	}

	for i := 0; i < N; i++ {
		for j := 0; j < N; j++ {
			if GRID[i][j] == 1 {
				dfs(i, j)
			}
		}
	}

	max := 0
	for i := 0; i < N; i++ {
		for j := 0; j < N; j++ {
			if GRID[i][j] == 0 && max < COST[i][j] {
				max = COST[i][j]
			}
		}
	}

	return max
}

var GRID [][]int
var N int
var COST [][]int

func dfs(x, y int) {
	for _, diff := range [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}} {
		i := x + diff[0]
		j := y + diff[1]
		if 0 <= i && i < N && 0 <= j && j < N && COST[x][y]+1 < COST[i][j] {
			COST[i][j] = COST[x][y] + 1
			dfs(i, j)
		}
	}
}

func main() {
	fmt.Println(maxDistance([][]int{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}))
	fmt.Println(maxDistance([][]int{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}))
}
