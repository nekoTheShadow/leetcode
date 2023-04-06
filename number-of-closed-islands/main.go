package main

import "fmt"

func closedIsland(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	set := map[int]bool{}

	land := -1
	for x := 0; x < m; x++ {
		for y := 0; y < n; y++ {
			if grid[x][y] != 0 {
				continue
			}

			queue := [][]int{{x, y}}
			grid[x][y] = land
			set[land] = true
			for len(queue) > 0 {
				top := queue[0]
				queue = queue[1:]

				for _, diff := range [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}} {
					i := top[0] + diff[0]
					j := top[1] + diff[1]
					if 0 <= i && i < m && 0 <= j && j < n && grid[i][j] == 0 {
						grid[i][j] = land
						queue = append(queue, []int{i, j})
					}
				}
			}

			land--
		}
	}

	for x := 0; x < m; x++ {
		delete(set, grid[x][0])
		delete(set, grid[x][n-1])
	}
	for y := 0; y < n; y++ {
		delete(set, grid[0][y])
		delete(set, grid[m-1][y])
	}

	return len(set)
}

func main() {
	fmt.Println(closedIsland([][]int{{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}}))
	fmt.Println(closedIsland([][]int{{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}}))

	grid := [][]int{
		{1, 1, 1, 1, 1, 1, 1},
		{1, 0, 0, 0, 0, 0, 1},
		{1, 0, 1, 1, 1, 0, 1},
		{1, 0, 1, 0, 1, 0, 1},
		{1, 0, 1, 1, 1, 0, 1},
		{1, 0, 0, 0, 0, 0, 1},
		{1, 1, 1, 1, 1, 1, 1},
	}
	fmt.Println(closedIsland(grid))
}
