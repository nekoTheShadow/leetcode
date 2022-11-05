package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(reverseVowels("hello"))
	fmt.Println(reverseVowels("leetcode"))
}

func reverseVowels(s string) string {
	isVowel := map[rune]bool{}
	for _, vowel := range "aeiouAEIOU" {
		isVowel[vowel] = true
	}

	vowels := []rune{}
	for _, ch := range s {
		if isVowel[ch] {
			vowels = append(vowels, ch)
		}
	}
	for i, n := 0, len(vowels); i < n/2; i++ {
		vowels[i], vowels[n-i-1] = vowels[n-i-1], vowels[i]
	}

	var ans strings.Builder
	x := 0
	for _, ch := range s {
		if isVowel[ch] {
			ans.WriteRune(vowels[x])
			x++
		} else {
			ans.WriteRune(ch)
		}
	}
	return ans.String()
}
