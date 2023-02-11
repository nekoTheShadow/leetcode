package main

import (
	"fmt"
	"math"
)

func shortestAlternatingPaths(n int, redEdges [][]int, blueEdges [][]int) []int {
	r := make([][]int, n)
	b := make([][]int, n)
	for i := 0; i < n; i++ {
		r = append(r, []int{})
		b = append(b, []int{})
	}
	for _, edge := range redEdges {
		r[edge[0]] = append(r[edge[0]], edge[1])
	}
	for _, edge := range blueEdges {
		b[edge[0]] = append(b[edge[0]], edge[1])
	}

	c := make([][]int, n)
	for i := 0; i < n; i++ {
		c[i] = make([]int, 2)
		c[i][0] = math.MaxInt
		c[i][1] = math.MaxInt
	}
	c[0][0] = 0
	c[0][1] = 0

	s := &Solution{n: n, r: r, b: b, c: c}
	s.dfs(0, 0)
	s.dfs(0, 1)

	ans := make([]int, n)
	for i := 0; i < n; i++ {
		if s.c[i][0] < s.c[i][1] {
			ans[i] = s.c[i][0]
		} else {
			ans[i] = s.c[i][1]
		}

		if ans[i] == math.MaxInt {
			ans[i] = -1
		}
	}

	return ans
}

type Solution struct {
	n int
	r [][]int
	b [][]int
	c [][]int
}

// 0: red
// 1: blue
func (s *Solution) dfs(x int, pre int) {
	if pre == 0 {
		for _, y := range s.b[x] {
			if s.c[x][0]+1 < s.c[y][1] {
				s.c[y][1] = s.c[x][0] + 1
				s.dfs(y, 1)
			}
		}
	} else {
		for _, y := range s.r[x] {
			if s.c[x][1]+1 < s.c[y][0] {
				s.c[y][0] = s.c[x][1] + 1
				s.dfs(y, 0)
			}
		}
	}
}

func main() {
	fmt.Println(shortestAlternatingPaths(3, [][]int{{0, 1}, {1, 2}}, [][]int{}))
	fmt.Println(shortestAlternatingPaths(3, [][]int{{0, 1}}, [][]int{{2, 1}}))
}
