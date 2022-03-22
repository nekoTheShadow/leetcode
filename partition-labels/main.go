package main

import (
	"fmt"
)

func partitionLabels(s string) []int {
	rightmost := map[rune]int{}
	for i, ch := range s {
		rightmost[ch] = i
	}

	ans := []int{}

	last := 0
	start := 0
	for i, ch := range s {
		last = max(last, rightmost[ch])
		if last == i {
			ans = append(ans, last-start+1)
			start = last + 1
		}
	}

	return ans
}

func max(a, b int) int {
	if a < b {
		return b
	} else {
		return a
	}
}

func main() {
	fmt.Println(partitionLabels("ababcbacadefegdehijhklij"))
	fmt.Println(partitionLabels("eccbbbbdec"))
}
