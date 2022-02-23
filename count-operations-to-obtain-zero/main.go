package main

import "fmt"

func countOperations(num1 int, num2 int) int {
	if num1 == 0 || num2 == 0 {
		return 0
	}

	if num1 <= num2 {
		return countOperations(num1, num2-num1) + 1
	} else {
		return countOperations(num1-num2, num2) + 1
	}
}

func main() {
	fmt.Println(countOperations(2, 3))   // => 3
	fmt.Println(countOperations(10, 10)) // => 1
}
