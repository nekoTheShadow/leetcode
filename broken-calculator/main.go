package main

import "fmt"

func brokenCalc(startValue int, target int) int {
	ans := 0
	for startValue < target {
		ans++
		if target%2 == 0 {
			target /= 2
		} else {
			target++
		}
	}

	return ans + (startValue - target)
}

func main() {
	fmt.Println(brokenCalc(2, 3))
	fmt.Println(brokenCalc(5, 8))
	fmt.Println(brokenCalc(3, 10))
}
