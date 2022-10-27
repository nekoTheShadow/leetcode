package main

import "fmt"

func main() {
	fmt.Println(largestOverlap([][]int{{1, 1, 0}, {0, 1, 0}, {0, 1, 0}}, [][]int{{0, 0, 0}, {0, 1, 1}, {0, 0, 1}}))
	fmt.Println(largestOverlap([][]int{{1}}, [][]int{{1}}))
	fmt.Println(largestOverlap([][]int{{0}}, [][]int{{0}}))
}

func largestOverlap(img1 [][]int, img2 [][]int) int {
	type Pair struct {
		x int
		y int
	}

	pairs1 := []Pair{}
	pairs2 := []Pair{}
	for x, row := range img1 {
		for y, bit := range row {
			if bit == 1 {
				pairs1 = append(pairs1, Pair{x: x, y: y})
			}
		}
	}
	for x, row := range img2 {
		for y, bit := range row {
			if bit == 1 {
				pairs2 = append(pairs2, Pair{x: x, y: y})
			}
		}
	}

	counter := map[Pair]int{}
	for _, pair1 := range pairs1 {
		for _, pair2 := range pairs2 {
			counter[Pair{x: pair1.x - pair2.x, y: pair1.y - pair2.y}]++
		}
	}

	max := 0
	for _, count := range counter {
		if max < count {
			max = count
		}
	}
	return max
}
