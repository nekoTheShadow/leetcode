package main

import "fmt"

func main() {
	fmt.Println(combinationSum3(3, 7))
	fmt.Println(combinationSum3(3, 9))
	fmt.Println(combinationSum3(4, 1))
}

func combinationSum3(k int, n int) [][]int {
	res := [][]int{}
	for bit := 0; bit < 1<<9; bit++ {
		a := []int{}
		sum := 0
		for i := 0; i < 9; i++ {
			if (bit & (1 << i)) != 0 {
				a = append(a, i+1)
				sum += i + 1
			}
		}

		if len(a) == k && sum == n {
			res = append(res, a)
		}
	}

	return res
}
