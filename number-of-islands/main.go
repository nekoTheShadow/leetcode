package main

import "fmt"

func main() {
	grid1 := [][]byte{
		{'1', '1', '1', '1', '0'},
		{'1', '1', '0', '1', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '0', '0', '0'},
	}
	fmt.Println(numIslands(grid1))

	grid2 := [][]byte{
		{'1', '1', '0', '0', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '1', '0', '0'},
		{'0', '0', '0', '1', '1'},
	}
	fmt.Println(numIslands(grid2))

	grid3 := [][]byte{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}}
	fmt.Println(numIslands(grid3))
}

func numIslands(grid [][]byte) int {
	c := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' {
				dfs(grid, i, j)
				c++
			}
		}
	}
	return c
}

func dfs(grid [][]byte, i, j int) {
	if 0 <= i && i < len(grid) && 0 <= j && j < len(grid[0]) && grid[i][j] == '1' {
		grid[i][j] = '#'
		dfs(grid, i+1, j)
		dfs(grid, i-1, j)
		dfs(grid, i, j+1)
		dfs(grid, i, j-1)
	}
}
