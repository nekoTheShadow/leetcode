package main

import (
	"fmt"
	"strconv"
)

func main() {
	fmt.Println(numDecodings("12"))
	fmt.Println(numDecodings("226"))
	fmt.Println(numDecodings("06"))
}

var S string
var DICT map[string]bool
var MEMO map[int]int

func numDecodings(s string) int {
	S = s
	DICT = map[string]bool{}
	for i := 1; i <= 26; i++ {
		DICT[strconv.Itoa(i)] = true
	}
	MEMO = map[int]int{}

	return dfs(0)
}

func dfs(cur int) int {
	if len(S) <= cur {
		return 1
	}

	if _, ok := MEMO[cur]; ok {
		return MEMO[cur]
	}

	sum := 0

	if _, ok := DICT[S[cur:cur+1]]; ok {
		sum += dfs(cur + 1)
	}

	if cur+1 < len(S) {
		if _, ok := DICT[S[cur:cur+2]]; ok {
			sum += dfs(cur + 2)
		}
	}

	MEMO[cur] = sum
	return MEMO[cur]
}
