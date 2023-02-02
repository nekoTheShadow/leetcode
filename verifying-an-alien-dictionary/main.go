package main

import (
	"fmt"
	"strings"
)

func isAlienSorted(words []string, order string) bool {
	for i := 0; i < len(words)-1; i++ {
		if !check(order, words[i], words[i+1]) {
			return false
		}
	}
	return true
}

func check(order, word1, word2 string) bool {
	n1 := len(word1)
	n2 := len(word2)

	for i := 0; i < n1; i++ {
		if i == n2 {
			return false
		}

		if word1[i] == word2[i] {
			continue
		}

		x1 := strings.IndexByte(order, word1[i])
		x2 := strings.IndexByte(order, word2[i])
		return x1 < x2
	}

	return n1 <= n2
}

func main() {
	fmt.Println(isAlienSorted([]string{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"))
	fmt.Println(isAlienSorted([]string{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"))
	fmt.Println(isAlienSorted([]string{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"))
}
