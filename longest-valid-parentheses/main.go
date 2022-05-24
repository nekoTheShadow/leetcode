package main

import "fmt"

func longestValidParentheses(s string) int {
	stack := []int{}
	ans := 0
	left := -1
	for i := 0; i < len(s); i++ {
		if s[i] == '(' {
			stack = append(stack, i)
		} else {
			if len(stack) == 0 {
				left = i
			} else {
				stack = stack[0 : len(stack)-1]
				var tmp int
				if len(stack) == 0 {
					tmp = i - left
				} else {
					tmp = i - stack[len(stack)-1]
				}
				if ans < tmp {
					ans = tmp
				}
			}
		}
	}
	return ans

}

func main() {
	fmt.Println(longestValidParentheses("(()"))
	fmt.Println(longestValidParentheses(")()())"))
	fmt.Println(longestValidParentheses(""))
}
