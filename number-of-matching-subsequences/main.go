package main

import "fmt"

func numMatchingSubseq(s string, words []string) int {
	for _, ch := range s {
		for i := 0; i < len(words); i++ {
			if len(words[i]) > 0 && rune(words[i][0]) == ch {
				words[i] = words[i][1:]
			}
		}
	}

	count := 0
	for _, word := range words {
		if len(word) == 0 {
			count++
		}
	}
	return count
}

func main() {
	fmt.Println(numMatchingSubseq("abcde", []string{"a", "bb", "acd", "ace"}))
	fmt.Println(numMatchingSubseq("dsahjpjauf", []string{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}))
}
