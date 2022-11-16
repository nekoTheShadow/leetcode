package main

import "fmt"

func guessNumber(n int) int {
	ng := 0
	ok := n + 1
	for abs(ok-ng) > 1 {
		mi := (ok + ng) / 2
		if guess(mi) == -1 || guess(mi) == 0 {
			ok = mi
		} else {
			ng = mi
		}
	}
	return ok
}

func abs(x int) int {
	if x > 0 {
		return x
	} else {
		return -x
	}
}

var pick int

func main() {
	pick = 6
	fmt.Println(guessNumber(10))

	pick = 1
	fmt.Println(guessNumber(1))

	pick = 1
	fmt.Println(guessNumber(2))
}

func guess(num int) int {
	if num > pick {
		return -1
	} else if num < pick {
		return 1
	} else {
		return 0
	}
}
