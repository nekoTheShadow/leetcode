package main

import "fmt"

func main() {
	fmt.Println(arrayStringsAreEqual([]string{"ab", "c"}, []string{"a", "bc"}))
	fmt.Println(arrayStringsAreEqual([]string{"a", "cb"}, []string{"ab", "c"}))
	fmt.Println(arrayStringsAreEqual([]string{"abc", "d", "defg"}, []string{"abcddefg"}))
}

func arrayStringsAreEqual(word1 []string, word2 []string) bool {
	i1 := 0
	j1 := 0
	i2 := 0
	j2 := 0

	f1 := false
	f2 := false

	for {
		c1 := word1[i1][j1]
		c2 := word2[i2][j2]
		if c1 != c2 {
			return false
		}

		if j1 == len(word1[i1])-1 {
			i1++
			j1 = 0
		} else {
			j1++
		}

		if j2 == len(word2[i2])-1 {
			i2++
			j2 = 0
		} else {
			j2++
		}

		if i1 == len(word1) {
			f1 = true
		}
		if i2 == len(word2) {
			f2 = true
		}
		if f1 || f2 {
			break
		}
	}
	return f1 && f2
}
