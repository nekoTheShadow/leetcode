package main

import "fmt"

func checkIfPangram(sentence string) bool {
	d := map[rune]bool{}
	for _, ch := range sentence {
		d[ch] = true
	}

	for _, ch := range "abcdefghijklmnopqrstuvwxyz" {
		if _, ok := d[ch]; !ok {
			return false
		}
	}
	return true
}

func main() {
	fmt.Println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"))
	fmt.Println(checkIfPangram("leetcode"))
}
