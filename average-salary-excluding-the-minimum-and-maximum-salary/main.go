package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(average([]int{4000, 3000, 1000, 2000}))
	fmt.Println(average([]int{1000, 2000, 3000}))
}

func average(salary []int) float64 {
	max := math.MinInt
	min := math.MaxInt
	sum := 0

	for _, v := range salary {
		if max < v {
			max = v
		}
		if v < min {
			min = v
		}
		sum += v
	}

	return float64(sum-max-min) / float64(len(salary)-2)
}
