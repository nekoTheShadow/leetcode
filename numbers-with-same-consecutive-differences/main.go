package main

import "fmt"

func main() {
	fmt.Println(numsSameConsecDiff(3, 7))
	fmt.Println(numsSameConsecDiff(2, 1))
}

func numsSameConsecDiff(n int, k int) []int {
	if n == 1 {
		a := []int{}
		for i := 1; i <= 9; i++ {
			a = append(a, i)
		}
		return a
	}

	a := []int{}
	for _, v := range numsSameConsecDiff(n-1, k) {
		if k == 0 {
			a = append(a, v*10+v%10)
		} else {
			x1 := v%10 - k
			x2 := v%10 + k

			if 0 <= x1 && x1 <= 9 {
				a = append(a, v*10+x1)
			}

			if 0 <= x2 && x2 <= 9 {
				a = append(a, v*10+x2)
			}
		}

	}

	return a
}
