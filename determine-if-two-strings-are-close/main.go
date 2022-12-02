package main

import (
	"fmt"
	"reflect"
	"sort"
)

func closeStrings(word1 string, word2 string) bool {
	a1 := map[rune]int{}
	a2 := map[rune]int{}
	for _, ch := range word1 {
		if _, ok := a1[ch]; !ok {
			a1[ch] = 0
		}
		a1[ch]++
	}
	for _, ch := range word2 {
		if _, ok := a2[ch]; !ok {
			a2[ch] = 0
		}
		a2[ch]++
	}

	b1 := []rune{}
	b2 := []rune{}
	c1 := []int{}
	c2 := []int{}
	for k, v := range a1 {
		b1 = append(b1, k)
		c1 = append(c1, v)
	}
	for k, v := range a2 {
		b2 = append(b2, k)
		c2 = append(c2, v)
	}
	sort.Slice(b1, func(i, j int) bool { return b1[i] < b1[j] })
	sort.Slice(b2, func(i, j int) bool { return b2[i] < b2[j] })
	sort.Ints(c1)
	sort.Ints(c2)
	return reflect.DeepEqual(b1, b2) && reflect.DeepEqual(c1, c2)
}

func main() {
	fmt.Println(closeStrings("abc", "bca"))
	fmt.Println(closeStrings("a", "aa"))
	fmt.Println(closeStrings("cabbba", "abbccc"))
}
