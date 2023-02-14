package main

import (
	"fmt"
	"strings"
)

func addBinary(a string, b string) string {
	x := len(a) - 1
	y := len(b) - 1

	r := 0
	ans := []int{}
	for x >= 0 || y >= 0 {
		var p int
		var q int

		if x >= 0 && a[x] == '1' {
			p = 1
		} else {
			p = 0
		}

		if y >= 0 && b[y] == '1' {
			q = 1
		} else {
			q = 0
		}
		ans = append(ans, (p+q+r)%2)
		r = (p + q + r) / 2

		x--
		y--
	}

	if r == 1 {
		ans = append(ans, r)
	}

	var sb strings.Builder
	for i := len(ans) - 1; i >= 0; i-- {
		if ans[i] == 1 {
			sb.WriteByte('1')
		} else {
			sb.WriteByte('0')
		}
	}
	return sb.String()
}

func main() {
	fmt.Println(addBinary("11", "1"))
	fmt.Println(addBinary("1010", "1011"))
}
