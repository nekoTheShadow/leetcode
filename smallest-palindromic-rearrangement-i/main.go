package main

import "fmt"

func smallestPalindrome(s string) string {
	counter := make([]int, 26)
	for _, ch := range s {
		counter[ch-'a']++
	}

	n := len(s)
	t := make([]rune, n)
	x := 0
	for ch := 0; ch < len(counter); ch++ {
		for counter[ch] > 1 {
			t[x] = rune('a' + ch)
			t[n-x-1] = rune('a' + ch)
			x++
			counter[ch] -= 2
		}

		// 奇数の場合
		if counter[ch] == 1 {
			t[n/2] = rune('a' + ch)
		}
	}

	return string(t)
}

func main() {
	fmt.Println(smallestPalindrome("babab"))
}
