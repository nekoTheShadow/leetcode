package main

import (
	"fmt"
	"strings"
)

func uniqueMorseRepresentations(words []string) int {
	dic := map[rune]string{
		'a': ".-",
		'b': "-...",
		'c': "-.-.",
		'd': "-..",
		'e': ".",
		'f': "..-.",
		'g': "--.",
		'h': "....",
		'i': "..",
		'j': ".---",
		'k': "-.-",
		'l': ".-..",
		'm': "--",
		'n': "-.",
		'o': "---",
		'p': ".--.",
		'q': "--.-",
		'r': ".-.",
		's': "...",
		't': "-",
		'u': "..-",
		'v': "...-",
		'w': ".--",
		'x': "-..-",
		'y': "-.--",
		'z': "--..",
	}

	set := map[string]bool{}
	for _, word := range words {
		var morse strings.Builder
		for _, ch := range word {
			morse.WriteString(dic[ch])
		}
		set[morse.String()] = true
	}

	return len(set)
}

func main() {
	fmt.Println(uniqueMorseRepresentations([]string{"gin", "zen", "gig", "msg"}))
	fmt.Println(uniqueMorseRepresentations([]string{"a"}))
}
