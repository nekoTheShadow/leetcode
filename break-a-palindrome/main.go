package main

import "fmt"

func breakPalindrome(palindrome string) string {
	n := len(palindrome)
	for i := 0; i < n/2; i++ {
		if palindrome[i] != 'a' {
			return palindrome[:i] + "a" + palindrome[i+1:]
		}
	}

	if n == 1 {
		return ""
	} else {
		return palindrome[:n-1] + "b"
	}
}

func main() {
	fmt.Println(breakPalindrome("abccba"))
	fmt.Println(breakPalindrome("a"))
	fmt.Println(breakPalindrome("aaa"))
}
