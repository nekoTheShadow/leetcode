package main

import (
	"fmt"
	"math"
	"sort"
)

func main() {
	fmt.Println(numberOfWeakCharacters([][]int{{5, 5}, {6, 3}, {3, 6}}))
	fmt.Println(numberOfWeakCharacters([][]int{{2, 2}, {3, 3}}))
	fmt.Println(numberOfWeakCharacters([][]int{{1, 5}, {10, 4}, {4, 3}}))
	fmt.Println(numberOfWeakCharacters([][]int{{1, 1}, {2, 1}, {2, 2}, {1, 2}}))
	fmt.Println(numberOfWeakCharacters([][]int{{7, 7}, {1, 2}, {9, 7}, {7, 3}, {3, 10}, {9, 8}, {8, 10}, {4, 3}, {1, 5}, {1, 5}}))
}

func numberOfWeakCharacters(properties [][]int) int {
	d := map[int][]int{}
	for _, property := range properties {
		if _, ok := d[property[0]]; !ok {
			d[property[0]] = []int{}
		}
		d[property[0]] = append(d[property[0]], property[1])
	}

	attacks := []int{}
	for attack := range d {
		attacks = append(attacks, attack)
	}
	sort.Slice(attacks, func(i, j int) bool { return attacks[i] > attacks[j] })

	ret := 0
	pivot := math.MinInt

	for _, attack := range attacks {
		for _, defence := range d[attack] {
			if pivot > defence {
				ret++
			}
		}

		for _, defence := range d[attack] {
			if pivot < defence {
				pivot = defence
			}
		}
	}

	return ret
}
