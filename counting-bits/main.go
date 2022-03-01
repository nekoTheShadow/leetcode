package main

import "fmt"

func countBits(n int) []int {
	c := []int{0}
	for i := 1; i <= n; i++ {
		c = append(c, c[i/2]+i%2)
	}
	return c
}

func main() {
	fmt.Println(countBits(2))
	fmt.Println(countBits(5))
}
