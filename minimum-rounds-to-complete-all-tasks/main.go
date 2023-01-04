package main

import "fmt"

func minimumRounds(tasks []int) int {
	c := map[int]int{}
	for _, task := range tasks {
		if _, ok := c[task]; !ok {
			c[task] = 0
		}
		c[task]++
	}

	ans := 0
	for _, v := range c {
		if v == 1 {
			return -1
		}

		if v%3 == 0 {
			ans += v / 3
		} else {
			ans += v/3 + 1
		}
	}
	return ans
}

func main() {
	fmt.Println(minimumRounds([]int{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}))
	fmt.Println(minimumRounds([]int{2, 3, 3}))
}
