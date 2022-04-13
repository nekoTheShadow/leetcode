package main

import "fmt"

func generateMatrix(n int) [][]int {
	a := make([][]int, n)
	for i := 0; i < n; i++ {
		a[i] = make([]int, n)
	}

	diffs := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
	ptr := 0
	x := 0
	y := 0
	for i := 1; i <= n*n; i++ {
		a[x][y] = i

		dx := x + diffs[ptr][0]
		dy := y + diffs[ptr][1]
		if 0 <= dx && dx < n && 0 <= dy && dy < n && a[dx][dy] == 0 {
			x = dx
			y = dy
		} else {
			ptr = (ptr + 1) % 4
			x = x + diffs[ptr][0]
			y = y + diffs[ptr][1]
		}
	}

	return a
}

func main() {
	fmt.Println(generateMatrix(3))
	fmt.Println(generateMatrix(1))
	fmt.Println(generateMatrix(4))
}
