package main

import (
	"fmt"
	"strings"
)

func removeKdigits(num string, k int) string {
	n := len(num) - k
	stack := []int{}
	for _, ch := range num {
		v := int(ch - '0')
		for k > 0 && len(stack) > 0 && v < stack[len(stack)-1] {
			stack = stack[0 : len(stack)-1]
			k--
		}
		stack = append(stack, v)
	}

	digits := []string{}
	for i := 0; i < n; i++ {
		digits = append(digits, fmt.Sprint(stack[i]))
	}
	answer := strings.TrimLeft(strings.Join(digits, ""), "0")
	if answer == "" {
		return "0"
	} else {
		return answer
	}
}

func main() {
	fmt.Println(removeKdigits("1432219", 3))
	fmt.Println(removeKdigits("10200", 1))
	fmt.Println(removeKdigits("10", 2))
	fmt.Println(removeKdigits("10001", 1))
	fmt.Println(removeKdigits("9", 1))
}
