package main

import "fmt"

func maxProduct(words []string) int {
	bits := []int{}
	for _, word := range words {
		bit := 0
		for _, alpha := range word {
			bit |= 1 << (alpha - 'a')
		}
		bits = append(bits, bit)
	}

	n := len(words)
	max := 0
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			if (bits[i] & bits[j]) == 0 {
				v := len(words[i]) * len(words[j])
				if max < v {
					max = v
				}
			}
		}
	}

	return max
}

func main() {
	fmt.Println(maxProduct([]string{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}))
	fmt.Println(maxProduct([]string{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}))
	fmt.Println(maxProduct([]string{"a", "aa", "aaa", "aaaa"}))
}
