package main

import "fmt"

func partition(s string) [][]string {
	matrix := [][]string{}
	if isPalindromic(s) {
		matrix = append(matrix, []string{s})
	}

	for i := 0; i < len(s)-1; i++ {
		if isPalindromic(s[:i+1]) {
			for _, a := range partition(s[i+1:]) {
				matrix = append(matrix, append([]string{s[:i+1]}, a...))
			}
		}
	}
	return matrix
}

func isPalindromic(s string) bool {
	n := len(s)
	for i := 0; i < n/2; i++ {
		if s[i] != s[n-i-1] {
			return false
		}
	}
	return true
}

func main() {
	fmt.Println(partition("aab"))
	fmt.Println(partition("a"))
}
