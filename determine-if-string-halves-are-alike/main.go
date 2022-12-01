package main

import (
	"fmt"
)

func halvesAreAlike(s string) bool {
	set := map[rune]bool{'a': true, 'i': true, 'u': true, 'e': true, 'o': true, 'A': true, 'I': true, 'U': true, 'E': true, 'O': true}

	a := 0
	b := 0
	n := len(s)
	for i, ch := range s {
		if _, ok := set[ch]; ok {
			if i < n/2 {
				a++
			} else {
				b++
			}
		}
	}
	return a == b
}

func main() {
	fmt.Println(halvesAreAlike("book"))
	fmt.Println(halvesAreAlike("textbook"))
}
