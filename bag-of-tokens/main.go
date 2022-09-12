package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(bagOfTokensScore([]int{100}, 50))
	fmt.Println(bagOfTokensScore([]int{100, 200}, 150))
	fmt.Println(bagOfTokensScore([]int{100, 200, 300, 400}, 200))
	fmt.Println(bagOfTokensScore([]int{81, 91, 31}, 73))
}

func bagOfTokensScore(tokens []int, power int) int {
	sort.Ints(tokens)

	ret := 0
	score := 0
	i := 0
	j := len(tokens) - 1
	for i <= j {
		if tokens[i] <= power {
			power -= tokens[i]
			i++
			score++
			if ret < score {
				ret = score
			}
		} else if score > 0 {
			score--
			power += tokens[j]
			j--
		} else {
			break
		}
	}
	return ret
}
