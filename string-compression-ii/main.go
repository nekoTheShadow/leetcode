package main

import (
	"fmt"
	"math"
)

func getLengthOfOptimalCompression(s string, k int) int {
	S = s
	MEMO = map[Key]int{}
	return solve(0, "", 0, k)
}

var S string
var MEMO map[Key]int

const INF = math.MaxInt / 2

type Key struct {
	start     int
	last      string
	lastCount int
	left      int
}

func solve(start int, last string, lastCount int, left int) int {
	if left < 0 {
		return INF
	}
	if start >= len(S) {
		return 0
	}

	key := Key{start: start, last: last, lastCount: lastCount, left: left}
	if _, ok := MEMO[key]; ok {
		return MEMO[key]
	}

	var ret int
	if S[start:start+1] == last {
		if lastCount == 1 || lastCount == 9 || lastCount == 99 {
			ret = 1 + solve(start+1, last, lastCount+1, left)
		} else {
			ret = solve(start+1, last, lastCount+1, left)
		}
	} else {
		v1 := 1 + solve(start+1, S[start:start+1], 1, left)
		v2 := solve(start+1, last, lastCount, left-1)
		if v1 < v2 {
			ret = v1
		} else {
			ret = v2
		}
	}

	MEMO[key] = ret
	return MEMO[key]
}

func main() {
	fmt.Println(getLengthOfOptimalCompression("aaabcccd", 2))
	fmt.Println(getLengthOfOptimalCompression("aabbaa", 2))
	fmt.Println(getLengthOfOptimalCompression("aaaaaaaaaaa", 0))
}
