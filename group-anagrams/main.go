package main

import (
	"fmt"
	"strings"
)

func groupAnagrams(strs []string) [][]string {
	d := map[string][]string{}
	for _, str := range strs {
		key := sort(str)
		if _, ok := d[key]; !ok {
			d[key] = []string{}
		}
		d[key] = append(d[key], str)
	}

	ans := [][]string{}
	for _, v := range d {
		ans = append(ans, v)
	}
	return ans
}

func sort(s string) string {
	d := map[rune]int{}
	for _, ch := range s {
		d[ch]++
	}

	var sb strings.Builder
	for _, ch := range "abcdefghijklmnopqrstuvwxyz" {
		for i := 0; i < d[ch]; i++ {
			sb.WriteRune(ch)
		}
	}
	return sb.String()
}

func main() {
	fmt.Println(groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))
	fmt.Println(groupAnagrams([]string{""}))
	fmt.Println(groupAnagrams([]string{"a"}))
}
