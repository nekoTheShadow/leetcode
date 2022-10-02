package main

import "fmt"

func main() {
	fmt.Println(numRollsToTarget(1, 6, 3))
	fmt.Println(numRollsToTarget(2, 6, 7))
	fmt.Println(numRollsToTarget(30, 30, 500))
}

func numRollsToTarget(n int, k int, target int) int {
	N = n
	K = k
	TARGET = target
	MEMO = map[Tuple]int{}
	return f(n, target)
}

var N int
var K int
var TARGET int
var MEMO map[Tuple]int
var MOD = 1000000000 + 7

type Tuple struct {
	N      int
	Target int
}

func f(n int, target int) int {
	if n == 0 {
		if target == 0 {
			return 1
		} else {
			return 0
		}
	}

	if target < 0 {
		return 0
	}

	tuple := Tuple{N: n, Target: target}
	if _, ok := MEMO[tuple]; ok {
		return MEMO[tuple]
	}

	ret := 0
	for i := 1; i <= K; i++ {
		ret += f(n-1, target-i)
		ret %= MOD
	}

	MEMO[tuple] = ret
	return MEMO[tuple]
}
