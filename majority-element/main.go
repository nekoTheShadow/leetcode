package main

import "fmt"

func majorityElement(nums []int) int {
	c := map[int]int{}
	for _, num := range nums {
		if _, ok := c[num]; !ok {
			c[num] = 0
		}
		c[num]++
	}

	maxK := 0
	maxV := 0
	for k, v := range c {
		if maxV < v {
			maxK = k
			maxV = v
		}
	}
	return maxK
}

func main() {
	fmt.Println(majorityElement([]int{3, 2, 3}))
	fmt.Println(majorityElement([]int{2, 2, 1, 1, 1, 2, 2}))
}
