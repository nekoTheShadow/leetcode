package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(minDominoRotations([]int{2, 1, 2, 4, 2, 2}, []int{5, 2, 6, 2, 3, 2}))
	fmt.Println(minDominoRotations([]int{3, 5, 1, 2, 3}, []int{3, 6, 3, 3, 4}))
}

func minDominoRotations(tops []int, bottoms []int) int {
	a := solve(tops[0], tops, bottoms)
	b := solve(bottoms[0], tops, bottoms)

	if a == math.MaxInt && b == math.MaxInt {
		return -1
	} else {
		return min(a, b)
	}
}

func solve(x int, tops []int, bottoms []int) int {
	p := 0 // 上に寄せる場合
	q := 0 // 下に寄せる場合
	for i := 0; i < len(tops); i++ {
		if !(tops[i] == x || bottoms[i] == x) {
			return math.MaxInt
		}
		if tops[i] != x && bottoms[i] == x {
			p++
		}
		if tops[i] == x && bottoms[i] != x {
			q++
		}
	}
	return min(p, q)
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
