package main

import (
	"fmt"
	"strings"
)

func removeDuplicates(s string) string {
	stack := []rune{}
	for _, ch := range s {
		if len(stack) > 0 && stack[len(stack)-1] == ch {
			stack = stack[0 : len(stack)-1]
		} else {
			stack = append(stack, ch)
		}
	}

	var ans strings.Builder
	for _, ch := range stack {
		ans.WriteRune(ch)
	}
	return ans.String()
}

func main() {
	fmt.Println(removeDuplicates("abbaca"))
	fmt.Println(removeDuplicates("azxxzy"))
}
