package main

import "fmt"

func canConstruct(ransomNote string, magazine string) bool {
	d := map[rune]int{}
	for _, ch := range magazine {
		if _, ok := d[ch]; !ok {
			d[ch] = 0
		}
		d[ch]++
	}

	for _, ch := range ransomNote {
		if v, ok := d[ch]; ok && v > 0 {
			d[ch]--
		} else {
			return false
		}
	}

	return true
}

func main() {
	fmt.Println(canConstruct("a", "b"))
	fmt.Println(canConstruct("aa", "ab"))
	fmt.Println(canConstruct("aa", "aab"))
}
