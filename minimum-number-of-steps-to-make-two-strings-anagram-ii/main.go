package main

import "fmt"

func minSteps(s string, t string) int {
	keys := "abcdefghijklmnopqrstuvwxyz"

	d1 := map[rune]int{}
	d2 := map[rune]int{}
	for _, k := range keys {
		d1[k] = 0
		d2[k] = 0
	}

	for _, ch := range s {
		d1[ch]++
	}
	for _, ch := range t {
		d2[ch]++
	}

	ans := 0
	for _, k := range keys {
		ans += abs(d1[k], d2[k])
	}
	return ans
}

func abs(x int, y int) int {
	if x < y {
		return y - x
	} else {
		return x - y
	}
}

func main() {
	fmt.Println(minSteps("leetcode", "coats"))
	fmt.Println(minSteps("night", "thing"))
}
