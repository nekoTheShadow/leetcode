package main

import (
	"fmt"
	"strings"
)

func prefixCount(words []string, pref string) int {
	count := 0
	for _, word := range words {
		if strings.HasPrefix(word, pref) {
			count++
		}
	}
	return count
}

func main() {
	fmt.Println(prefixCount([]string{"pay", "attention", "practice", "attend"}, "at"))
	fmt.Println(prefixCount([]string{"leetcode", "win", "loops", "success"}, "code"))
}
