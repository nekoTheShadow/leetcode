package main

import (
	"fmt"
	"sort"
	"strings"
)

func frequencySort(s string) string {
	c := map[rune]int{}
	for _, ch := range s {
		if _, ok := c[ch]; !ok {
			c[ch] = 0
		}
		c[ch]++
	}

	chs := []rune{}
	for ch := range c {
		chs = append(chs, ch)
	}
	sort.Slice(chs, func(i, j int) bool { return c[chs[i]] > c[chs[j]] })

	var ans strings.Builder
	for _, ch := range chs {
		for i := 0; i < c[ch]; i++ {
			ans.WriteRune(ch)
		}
	}

	return ans.String()
}

func main() {
	fmt.Println(frequencySort("tree"))
	fmt.Println(frequencySort("cccaaa"))
	fmt.Println(frequencySort("Aabb"))
}
