package main

import (
	"fmt"
	"sort"
)

func distanceLimitedPathsExist(n int, edgeList [][]int, queries [][]int) []bool {
	for i := 0; i < len(queries); i++ {
		queries[i] = append(queries[i], i)
	}
	sort.Slice(edgeList, func(i, j int) bool { return edgeList[i][2] < edgeList[j][2] })
	sort.Slice(queries, func(i, j int) bool { return queries[i][2] < queries[j][2] })

	res := make([]bool, len(queries))
	uf := NewUnionFind(n)
	x := 0
	for _, query := range queries {
		for x < len(edgeList) && edgeList[x][2] < query[2] {
			uf.Union(edgeList[x][0], edgeList[x][1])
			x++
		}

		res[query[3]] = uf.Find(query[0]) == uf.Find(query[1])
	}
	return res
}

type UnionFind struct {
	parents map[int]int
	sizes   map[int]int
}

func NewUnionFind(n int) *UnionFind {
	uf := UnionFind{
		parents: map[int]int{},
		sizes:   map[int]int{},
	}
	return &uf
}

func (uf *UnionFind) Find(x int) int {
	if _, ok := uf.parents[x]; !ok {
		return x
	}
	uf.parents[x] = uf.Find(uf.parents[x])
	return uf.parents[x]
}

func (uf *UnionFind) Union(x, y int) {
	x = uf.Find(x)
	y = uf.Find(y)
	if x == y {
		return
	}

	if _, ok := uf.sizes[x]; !ok {
		uf.sizes[x] = 1
	}
	if _, ok := uf.sizes[y]; !ok {
		uf.sizes[y] = 1
	}

	if uf.sizes[x] < uf.sizes[y] {
		uf.parents[x] = y
		uf.sizes[y] += uf.sizes[x]
	} else {
		uf.parents[y] = x
		uf.sizes[x] += uf.sizes[y]
	}
}

func main() {
	fmt.Println(distanceLimitedPathsExist(3, [][]int{{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}}, [][]int{{0, 1, 2}, {0, 2, 5}}))
	fmt.Println(distanceLimitedPathsExist(5, [][]int{{0, 1, 10}, {1, 2, 5}, {2, 3, 9}, {3, 4, 13}}, [][]int{{0, 4, 14}, {1, 4, 13}}))
}
