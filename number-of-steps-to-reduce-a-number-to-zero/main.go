package main

import "fmt"

func numberOfSteps(num int) int {
	c := 0
	for num > 0 {
		if num%2 == 0 {
			num /= 2
		} else {
			num--
		}
		c++
	}
	return c
}

func main() {
	fmt.Println(numberOfSteps(14))
	fmt.Println(numberOfSteps(8))
	fmt.Println(numberOfSteps(123))
}
