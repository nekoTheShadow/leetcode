package main

import "strings"

func divideString(s string, k int, fill byte) []string {
	tokens := []string{}
	n := len(s)
	for i := 0; i < n; i += k {
		j := min(i+k, n)
		tokens = append(tokens, s[i:j]+strings.Repeat(string(fill), k-(j-i)))
	}
	return tokens
}

func min(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
