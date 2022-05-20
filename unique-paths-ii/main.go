package main

import "fmt"

func main() {
	fmt.Println(uniquePathsWithObstacles([][]int{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}))
	fmt.Println(uniquePathsWithObstacles([][]int{{0, 1}, {0, 0}}))
	fmt.Println(uniquePathsWithObstacles([][]int{{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}))
}

var M int
var N int
var G [][]int
var MEMO [][]int

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	if obstacleGrid[0][0] == 1 {
		return 0
	}

	M = len(obstacleGrid)
	N = len(obstacleGrid[0])
	G = obstacleGrid

	MEMO = make([][]int, M)
	for i := 0; i < M; i++ {
		MEMO[i] = make([]int, N)
	}

	return f(M-1, N-1)
}

func f(x, y int) int {
	if x == 0 && y == 0 {
		return 1
	}

	if !(0 <= x && x < M && 0 <= y && y < N && G[x][y] == 0) {
		return 0
	}

	if MEMO[x][y] != 0 {
		return MEMO[x][y]
	}

	MEMO[x][y] = f(x-1, y) + f(x, y-1)
	return MEMO[x][y]
}
