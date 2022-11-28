package main

import "sort"

func findWinners(matches [][]int) [][]int {
	counter := map[int]int{}
	for _, match := range matches {
		w := match[0]
		l := match[1]
		if _, ok := counter[w]; !ok {
			counter[w] = 0
		}
		if _, ok := counter[l]; !ok {
			counter[l] = 0
		}
		counter[l]++
	}

	answer := [][]int{{}, {}}
	for k, v := range counter {
		if v == 0 {
			answer[0] = append(answer[0], k)
		}
		if v == 1 {
			answer[1] = append(answer[1], k)
		}
	}
	sort.Ints(answer[0])
	sort.Ints(answer[1])
	return answer
}
