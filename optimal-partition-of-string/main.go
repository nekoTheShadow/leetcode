package main

import "fmt"

func partitionString(s string) int {
	d := map[rune]bool{}

	ans := 0
	for _, c := range s {
		if _, ok := d[c]; ok {
			ans++
			d = map[rune]bool{}
			d[c] = true
		} else {
			d[c] = true
		}
	}

	if len(d) > 0 {
		ans++
	}

	return ans
}

func main() {
	fmt.Println(partitionString("abacaba"))
	fmt.Println(partitionString("ssssss"))
}
