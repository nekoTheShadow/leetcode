package main

import (
	"fmt"
	"sort"
)

func maxRunTime(n int, batteries []int) int64 {
	sum := 0
	for _, battery := range batteries {
		sum += battery
	}

	sort.Ints(batteries)
	for i := len(batteries) - 1; i >= 0; i-- {
		if batteries[i] > sum/n {
			n--
			sum -= batteries[i]
		} else {
			break
		}
	}
	return int64(sum / n)
}

func main() {
	fmt.Println(maxRunTime(2, []int{3, 3, 3}))    //=> 4
	fmt.Println(maxRunTime(2, []int{1, 1, 1, 1})) //=> 2
}
