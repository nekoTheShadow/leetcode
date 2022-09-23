package main

import "fmt"

func concatenatedBinary(n int) int {
	ret := 0
	base := 1
	mod := 1000000000 + 7
	for i := n; i >= 1; i-- {
		x := i
		for x > 0 {
			ret += (x % 2) * base
			ret %= mod

			base *= 2
			base %= mod

			x /= 2
		}
	}
	return ret
}

func main() {
	fmt.Println(concatenatedBinary(1))
	fmt.Println(concatenatedBinary(3))
	fmt.Println(concatenatedBinary(12))
}
