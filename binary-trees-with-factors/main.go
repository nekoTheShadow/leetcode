package main

import (
	"fmt"
)

func numFactoredBinaryTrees(arr []int) int {
	MEMO = map[int]int{}

	SET = map[int]bool{}
	for _, v := range arr {
		SET[v] = true
	}

	sum := 0
	for _, v := range arr {
		sum += f(v)
		sum %= MOD
	}
	return sum
}

var SET map[int]bool
var MEMO map[int]int
var MOD = 1000000000 + 7

func f(v int) int {
	if _, ok := MEMO[v]; ok {
		return MEMO[v]
	}

	ret := 1
	for x := range SET {
		if v%x != 0 {
			continue
		}

		y := v / x
		if _, ok := SET[y]; ok {
			ret += (f(x) * f(y)) % MOD
			ret %= MOD
		}
	}
	MEMO[v] = ret
	return ret
}

func main() {
	fmt.Println(numFactoredBinaryTrees([]int{2, 4}))
	fmt.Println(numFactoredBinaryTrees([]int{2, 4, 5, 10}))
}
