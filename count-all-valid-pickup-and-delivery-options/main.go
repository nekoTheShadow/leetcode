package main

import "fmt"

func countOrders(n int) int {
	ans := 1
	for m := 2 * n; m >= 2; m -= 2 {
		ans *= m * (m - 1) / 2
		ans %= 1000000007
	}
	return ans
}

func main() {
	fmt.Println(countOrders(1))
	fmt.Println(countOrders(2))
	fmt.Println(countOrders(3))
}
