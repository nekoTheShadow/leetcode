package main

import "fmt"

func main() {
	fmt.Println(detectCapitalUse("USA"))
	fmt.Println(detectCapitalUse("FlaG"))
	fmt.Println(detectCapitalUse("g"))
}

func detectCapitalUse(word string) bool {
	upper := map[rune]bool{
		'A': true,
		'B': true,
		'C': true,
		'D': true,
		'E': true,
		'F': true,
		'G': true,
		'H': true,
		'I': true,
		'J': true,
		'K': true,
		'L': true,
		'M': true,
		'N': true,
		'O': true,
		'P': true,
		'Q': true,
		'R': true,
		'S': true,
		'T': true,
		'U': true,
		'V': true,
		'W': true,
		'X': true,
		'Y': true,
		'Z': true,
	}

	check1 := true // すべて大文字
	check2 := true // すべて小文字
	check3 := true // 1文字目のみ大文字、それ以外は小文字
	for i, ch := range word {
		if _, ok := upper[ch]; ok {
			check2 = false
		} else {
			check1 = false
		}

		if i == 0 {
			if _, ok := upper[ch]; !ok {
				check3 = false
			}
		} else {
			if _, ok := upper[ch]; ok {
				check3 = false
			}
		}
	}
	return check1 || check2 || check3
}
