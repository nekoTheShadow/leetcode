package main

import "fmt"

func minimumPushes(word string) int {
	n := len(word)
	if n <= 8 {
		return 1 * n
	} else if n <= 16 {
		return 1*8 + 2*(n-8)
	} else if n <= 24 {
		return 1*8 + 2*8 + 3*(n-16)
	} else {
		return 1*8 + 2*8 + 3*8 + 4*(n-24)
	}
}

func main() {
	fmt.Println("Hello World")
}
