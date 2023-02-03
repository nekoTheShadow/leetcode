package main

import (
	"fmt"
	"strings"
)

func convert(s string, numRows int) string {
	if numRows == 1 {
		return s
	}

	matrix := [][]rune{}
	for i := 0; i < numRows; i++ {
		matrix = append(matrix, []rune{})
	}

	x := 0
	dx := 1
	for _, ch := range s {
		matrix[x] = append(matrix[x], ch)
		if !(0 <= x+dx && x+dx < numRows) {
			dx *= -1
		}
		x += dx
	}

	var ans strings.Builder
	for _, row := range matrix {
		for _, ch := range row {
			ans.WriteRune(ch)
		}
	}
	return ans.String()
}

func main() {
	fmt.Println(convert("PAYPALISHIRING", 3))
	fmt.Println(convert("PAYPALISHIRING", 4))
	fmt.Println(convert("A", 1))
	fmt.Println(convert("AB", 1))
}
