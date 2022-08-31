package main

import "fmt"

func main() {
	fmt.Println(pacificAtlantic([][]int{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}))
}
func pacificAtlantic(heights [][]int) [][]int {
	m := len(heights)
	n := len(heights[0])

	a1 := make([][]bool, m)
	a2 := make([][]bool, m)
	for i := 0; i < m; i++ {
		a1[i] = make([]bool, n)
		a2[i] = make([]bool, n)

		for j := 0; j < n; j++ {
			a1[i][j] = (i == 0 || j == 0)
			a2[i][j] = (i == m-1 || j == n-1)
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if a1[i][j] {
				dfs(-1, -1, i, j, heights, a1)
			}
			if a2[i][j] {
				dfs(-1, -1, i, j, heights, a2)
			}
		}
	}

	ret := [][]int{}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if a1[i][j] && a2[i][j] {
				ret = append(ret, []int{i, j})
			}
		}
	}
	return ret
}

func dfs(prevX, prevY, curX, curY int, heights [][]int, a [][]bool) {
	for _, diff := range [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}} {
		nxtX := curX + diff[0]
		nxtY := curY + diff[1]
		if !(prevX == nxtX && prevY == nxtY) && (0 <= nxtX && nxtX < len(heights) && 0 <= nxtY && nxtY < len(heights[0])) && !a[nxtX][nxtY] && heights[curX][curY] <= heights[nxtX][nxtY] {
			a[nxtX][nxtY] = true
			dfs(curX, curY, nxtX, nxtY, heights, a)
		}
	}
}
