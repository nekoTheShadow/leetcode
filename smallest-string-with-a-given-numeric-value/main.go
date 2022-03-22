package main

import (
	"fmt"
	"strings"
)

func getSmallestString(n int, k int) string {
	tot := n
	a := []int{}
	for i := 0; i < n; i++ {
		a = append(a, 1)
	}

	for i := 0; i < n; i++ {
		diff := Min(25, k-tot)
		a[i] += diff
		tot += diff
	}

	var sb strings.Builder
	for i := len(a) - 1; i >= 0; i-- {
		sb.WriteRune(rune(int('a') + a[i] - 1))
	}
	return sb.String()
}

func Min(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}

func main() {
	fmt.Println(getSmallestString(3, 27))
	fmt.Println(getSmallestString(5, 73))
}
