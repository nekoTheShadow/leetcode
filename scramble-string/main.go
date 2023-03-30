package main

import "fmt"

func isScramble(s1 string, s2 string) bool {
	if s1 == s2 {
		return true
	}

	n := len(s1)

	a := make([]int, 26)
	for i := 0; i < n; i++ {
		a[int(s1[i])-int('a')]++
		a[int(s2[i])-int('a')]--
	}
	for i := 0; i < 26; i++ {
		if a[i] != 0 {
			return false
		}
	}

	for i := 1; i <= n-1; i++ {
		if isScramble(s1[:i], s2[:i]) && isScramble(s1[i:], s2[i:]) {
			return true
		}
		if isScramble(s1[:i], s2[n-i:]) && isScramble(s1[i:], s2[:n-i]) {
			return true
		}
	}

	return false
}

func main() {
	fmt.Println(isScramble("great", "rgeat"))
	fmt.Println(isScramble("abcde", "caebd"))
	fmt.Println(isScramble("a", "a"))
}
