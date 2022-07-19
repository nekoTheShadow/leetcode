package main

import "fmt"

func generate(numRows int) [][]int {
	tri := [][]int{{1}}
	for i := 1; i < numRows; i++ {
		row := []int{}
		for j := 0; j <= i; j++ {
			val := 0
			if j < len(tri[i-1]) {
				val += tri[i-1][j]
			}
			if 0 <= j-1 {
				val += tri[i-1][j-1]
			}
			row = append(row, val)
		}
		tri = append(tri, row)
	}
	return tri
}

func main() {
	fmt.Println(generate(5))
	fmt.Println(generate(1))
}
