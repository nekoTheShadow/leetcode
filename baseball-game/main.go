package main

import (
	"fmt"
	"strconv"
)

type Stack []int

func (s *Stack) Push(v int) {
	*s = append(*s, v)
}

func (s *Stack) Pop() int {
	v := (*s)[len(*s)-1]
	*s = (*s)[0 : len(*s)-1]
	return v
}

func calPoints(ops []string) int {
	stack := Stack([]int{})

	for _, op := range ops {
		if op == "+" {
			v1 := stack.Pop()
			v2 := stack.Pop()
			stack.Push(v2)
			stack.Push(v1)
			stack.Push(v1 + v2)
		} else if op == "D" {
			v := stack.Pop()
			stack.Push(v)
			stack.Push(v * 2)
		} else if op == "C" {
			stack.Pop()
		} else {
			v, _ := strconv.Atoi(op)
			stack.Push(v)
		}
	}

	ans := 0
	for len(stack) > 0 {
		ans += stack.Pop()
	}

	return ans
}

func main() {
	fmt.Println(calPoints([]string{"5", "2", "C", "D", "+"}))
	fmt.Println(calPoints([]string{"5", "-2", "4", "C", "D", "9", "+", "+"}))
	fmt.Println(calPoints([]string{"1"}))
}
