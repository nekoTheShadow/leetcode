package main

import (
	"fmt"
	"sort"
	"strings"
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

func smallestStringWithSwaps(s string, pairs [][]int) string {
	n := len(s)
	uf := NewUnionFind(n)
	for _, pair := range pairs {
		uf.Union(pair[0], pair[1])
	}

	group := map[int][]int{}
	for i := 0; i < n; i++ {
		root := uf.Find(i)
		if _, ok := group[root]; !ok {
			group[root] = []int{}
		}
		group[root] = append(group[root], i)
	}

	ans := make([]string, n)
	for _, idxs := range group {
		chars := []string{}
		for _, idx := range idxs {
			chars = append(chars, s[idx:idx+1])
		}
		sort.Strings(chars)

		for i := 0; i < len(chars); i++ {
			ans[idxs[i]] = chars[i]
		}
	}

	return strings.Join(ans, "")
}

func main() {
	fmt.Println(smallestStringWithSwaps("dcab", [][]int{{0, 3}, {1, 2}}))
	fmt.Println(smallestStringWithSwaps("dcab", [][]int{{0, 3}, {1, 2}, {0, 2}}))
	fmt.Println(smallestStringWithSwaps("cba", [][]int{{0, 1}, {1, 2}}))
}
