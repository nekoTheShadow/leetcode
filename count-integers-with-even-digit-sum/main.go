package main

import "fmt"

func countEven(num int) int {
	ans := 0
	for i := 1; i <= num; i++ {
		if digitSums(i)%2 == 0 {
			ans++
		}
	}
	return ans
}

func digitSums(x int) int {
	sum := 0
	for x > 0 {
		sum += x % 10
		x /= 10
	}
	return sum
}

func main() {
	fmt.Println(countEven(4))
	fmt.Println(countEven(30))
}
