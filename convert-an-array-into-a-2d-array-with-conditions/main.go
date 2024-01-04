package main

import "fmt"

func findMatrix(nums []int) [][]int {
	sets := []map[int]bool{}
	for _, num := range nums {
		found := false
		for _, set := range sets {
			if _, ok := set[num]; !ok {
				set[num] = true
				found = true
				break
			}
		}
		if !found {
			sets = append(sets, map[int]bool{num: true})
		}
	}

	mat := [][]int{}
	for _, set := range sets {
		if len(set) == 0 {
			continue
		}
		vals := []int{}
		for val := range set {
			vals = append(vals, val)
		}
		mat = append(mat, vals)
	}
	return mat
}

func main() {
	fmt.Println(findMatrix([]int{1, 3, 4, 1, 2, 3, 1}))
	fmt.Println(findMatrix([]int{1, 2, 3, 4}))
	fmt.Println(findMatrix([]int{9, 8, 8, 4, 9, 8, 8, 3, 9}))
}
