package main

import (
	"fmt"
	"sort"
)

type UnionFind struct {
	parent []int
}

func NewUnionFind(n int) *UnionFind {
	parent := []int{}
	for i := 0; i < n; i++ {
		parent = append(parent, i)
	}
	return &UnionFind{parent: parent}
}

func (uf *UnionFind) Find(x int) int {
	if uf.parent[x] == x {
		return x
	}

	uf.parent[x] = uf.Find(uf.parent[x])
	return uf.parent[x]
}

func (uf *UnionFind) Union(x, y int) {
	x = uf.Find(x)
	y = uf.Find(y)
	if x == y {
		return
	}
	uf.parent[x] = y
}

func Abs(x int) int {
	if x >= 0 {
		return x
	} else {
		return -x
	}
}

func minCostConnectPoints(points [][]int) int {
	n := len(points)

	edges := [][]int{}
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			x1 := points[i][0]
			y1 := points[i][1]
			x2 := points[j][0]
			y2 := points[j][1]
			d := Abs(x1-x2) + Abs(y1-y2)
			edges = append(edges, []int{d, i, j})
		}
	}

	sort.Slice(edges, func(i, j int) bool {
		d1 := edges[i][0]
		d2 := edges[j][0]
		return d1 < d2
	})

	uf := NewUnionFind(n)
	ans := 0
	for _, edge := range edges {
		d := edge[0]
		x := edge[1]
		y := edge[2]
		if uf.Find(x) == uf.Find(y) {
			continue
		}
		ans += d
		uf.Union(x, y)
	}

	return ans
}

func main() {
	fmt.Println(minCostConnectPoints([][]int{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}))
	fmt.Println(minCostConnectPoints([][]int{{3, 12}, {-2, 5}, {-4, 1}}))
}
