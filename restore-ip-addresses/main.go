package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	fmt.Println(restoreIpAddresses("25525511135"))
	fmt.Println(restoreIpAddresses("0000"))
	fmt.Println(restoreIpAddresses("101023"))
}

func restoreIpAddresses(s string) []string {
	S = s
	A = []string{}
	B = []string{}
	D = map[string]bool{}
	for i := 0; i <= 255; i++ {
		D[strconv.Itoa(i)] = true
	}

	dfs(0, 3)
	return B
}

var S string
var A []string
var B []string
var D map[string]bool

func dfs(i int, n int) {
	if n == 0 {
		if _, ok := D[S[i:]]; ok {
			A = append(A, S[i:])
			B = append(B, strings.Join(A, "."))
			A = A[:len(A)-1]
		}
		return
	}

	for j := i + 1; j <= i+3; j++ {
		if !(j < len(S)) {
			break
		}

		if _, ok := D[S[i:j]]; ok {
			A = append(A, S[i:j])
			dfs(j, n-1)
			A = A[:len(A)-1]
		}
	}
}
