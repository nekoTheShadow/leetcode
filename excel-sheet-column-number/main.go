package main

import (
	"fmt"
	"math"
)

func titleToNumber(columnTitle string) int {
	ans := 0
	for i := len(columnTitle) - 1; i >= 0; i-- {
		ans += (int(columnTitle[i]) - 64) * int(math.Pow(26, float64(len(columnTitle)-i-1)))
	}
	return ans
}

func main() {
	fmt.Println(titleToNumber("A"))
	fmt.Println(titleToNumber("AB"))
	fmt.Println(titleToNumber("ZY"))
}
