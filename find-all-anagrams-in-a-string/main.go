package main

import (
	"reflect"
)

func findAnagrams(s string, p string) []int {
	if len(s) < len(p) {
		return []int{}
	}

	c1 := make([]int, 26)
	c2 := make([]int, 26)

	for _, ch := range p {
		c1[ch-'a']++
	}
	for i := 0; i < len(p)-1; i++ {
		c2[s[i]-'a']++
	}

	ans := []int{}
	for i := len(p) - 1; i < len(s); i++ {
		j := i - len(p) + 1
		c2[s[i]-'a']++
		if reflect.DeepEqual(c1, c2) {
			ans = append(ans, j)
		}
		c2[s[j]-'a']--
	}
	return ans
}
