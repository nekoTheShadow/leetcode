package main

import (
	"fmt"
	"sort"
)

func minimumSum(num int) int {
	digits := []int{}
	for i := 0; i < 4; i++ {
		digits = append(digits, num%10)
		num /= 10
	}
	sort.Ints(digits)

	a := digits[0]*10 + digits[2]
	b := digits[1]*10 + digits[3]
	return a + b
}

func main() {
	fmt.Println(minimumSum(2932)) //=> 52
	fmt.Println(minimumSum(4009)) //=> 13
}
