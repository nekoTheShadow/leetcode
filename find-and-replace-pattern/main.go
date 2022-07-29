package main

import (
	"fmt"
	"reflect"
)

func main() {
	fmt.Println(findAndReplacePattern([]string{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"))
}

func findAndReplacePattern(words []string, pattern string) []string {
	ans := []string{}
	for _, word := range words {
		if reflect.DeepEqual(f(word), f(pattern)) {
			ans = append(ans, word)
		}
	}
	return ans
}

func f(s string) []int {
	grp := 0
	grps := []int{}
	set := map[rune]int{}

	for _, c := range s {
		if _, ok := set[c]; !ok {
			set[c] = grp
			grp++
		}
		grps = append(grps, set[c])
	}

	return grps
}
