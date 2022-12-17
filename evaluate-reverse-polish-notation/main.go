package main

import (
	"fmt"
	"strconv"
)

func evalRPN(tokens []string) int {
	ops := map[string]func(int, int) int{}
	ops["+"] = func(x, y int) int { return x + y }
	ops["-"] = func(x, y int) int { return x - y }
	ops["*"] = func(x, y int) int { return x * y }
	ops["/"] = func(x, y int) int { return x / y }

	stack := []int{}
	for _, token := range tokens {
		if _, ok := ops[token]; ok {
			number1 := stack[len(stack)-2]
			number2 := stack[len(stack)-1]
			stack = stack[:len(stack)-2]
			number3 := ops[token](number1, number2)
			stack = append(stack, number3)
		} else {
			number, _ := strconv.Atoi(token)
			stack = append(stack, number)
		}
	}
	return stack[0]
}

func main() {
	fmt.Println(evalRPN([]string{"2", "1", "+", "3", "*"}))
	fmt.Println(evalRPN([]string{"4", "13", "5", "/", "+"}))
	fmt.Println(evalRPN([]string{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}))
}
