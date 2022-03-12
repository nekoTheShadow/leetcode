package main

import "fmt"

func main() {
	fmt.Println(minimumTime([]int{1, 2, 3}, 5))
	fmt.Println(minimumTime([]int{2}, 1))
	fmt.Println(minimumTime([]int{5, 10, 10}, 9))
}

func minimumTime(time []int, totalTrips int) int64 {
	ok := Max(time)*totalTrips + 1
	ng := 0

	for Abs(ok-ng) > 1 {
		mi := (ok + ng) / 2

		sum := 0
		for i := 0; i < len(time); i++ {
			sum += mi / time[i]
		}

		if totalTrips <= sum {
			ok = mi
		} else {
			ng = mi
		}
	}

	return int64(ok)
}

func Abs(x int) int {
	if x > 0 {
		return x
	} else {
		return -x
	}
}

func Max(a []int) int {
	max := a[0]
	for _, v := range a {
		if max < v {
			max = v
		}
	}
	return max
}
