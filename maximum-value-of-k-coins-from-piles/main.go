package main

import "fmt"

func maxValueOfCoins(piles [][]int, k int) int {
	P = piles
	MEMO = map[Key]int{}
	return dfs(0, k)
}

var P [][]int
var MEMO map[Key]int

func dfs(cur int, k int) int {
	if cur == len(P) {
		return 0
	}

	key := Key{cur: cur, k: k}
	if _, ok := MEMO[key]; ok {
		return MEMO[key]
	}

	max := dfs(cur+1, k)
	sum := 0
	for i := 0; i < Min(k, len(P[cur])); i++ {
		sum += P[cur][i]
		max = Max(max, dfs(cur+1, k-i-1)+sum)
	}

	MEMO[key] = max
	return max
}

func Max(x, y int) int {
	if x < y {
		return y
	} else {
		return x
	}
}

func Min(x, y int) int {
	if x < y {
		return x
	} else {
		return y
	}
}

type Key struct {
	cur int
	k   int
}

func main() {
	fmt.Println(maxValueOfCoins([][]int{{1, 100, 3}, {7, 8, 9}}, 2))
	fmt.Println(maxValueOfCoins([][]int{{100}, {100}, {100}, {100}, {100}, {100}, {1, 1, 1, 1, 1, 1, 700}}, 7))
}
