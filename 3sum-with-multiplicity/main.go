package main

import (
	"fmt"
)

func threeSumMulti(arr []int, target int) int {
	d := map[int]int{}
	d[arr[len(arr)-1]+arr[len(arr)-2]] = 1

	ans := 0
	for i := len(arr) - 3; i >= 0; i-- {
		if v, ok := d[target-arr[i]]; ok {
			ans += v
			ans %= 1000000000 + 7
		}

		for j := i + 1; j < len(arr); j++ {
			v := arr[i] + arr[j]
			if _, ok := d[v]; !ok {
				d[v] = 0
			}
			d[v]++
		}
	}
	return ans
}

func main() {
	fmt.Println(threeSumMulti([]int{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8))
	fmt.Println(threeSumMulti([]int{1, 1, 2, 2, 2, 2}, 5))
}
