package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(minDifficulty([]int{6, 5, 4, 3, 2, 1}, 2))
	fmt.Println(minDifficulty([]int{9, 9, 9}, 4))
	fmt.Println(minDifficulty([]int{1, 1, 1}, 3))
}

func minDifficulty(jobDifficulty []int, d int) int {
	A = jobDifficulty
	MEMO = map[Key]int{}

	ret := solve(0, d)
	if ret == INF {
		return -1
	} else {
		return ret
	}
}

const INF = math.MaxInt/2 - 1

var A []int

var MEMO map[Key]int

type Key struct {
	cur int
	d   int
}

func solve(cur int, d int) int {
	if d == 0 {
		if cur == len(A) {
			return 0
		} else {
			return INF
		}
	}

	if cur == len(A) {
		return INF
	}

	key := Key{cur: cur, d: d}
	if _, ok := MEMO[key]; ok {
		return MEMO[key]
	}

	ret := INF
	for i := cur; i < len(A); i++ {
		ret = Min(ret, Max(A[cur:i+1]...)+solve(i+1, d-1))
	}
	MEMO[key] = ret
	return ret
}

func Max(a ...int) int {
	max := a[0]
	for i := 1; i < len(a); i++ {
		if max < a[i] {
			max = a[i]
		}
	}
	return max
}

func Min(a ...int) int {
	min := a[0]
	for i := 1; i < len(a); i++ {
		if a[i] < min {
			min = a[i]
		}
	}
	return min
}
