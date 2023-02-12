package main

import "fmt"

func minimumFuelCost(roads [][]int, seats int) int64 {
	n := len(roads) + 1
	G = make([][]int, n)
	for i := 0; i < n; i++ {
		G[i] = []int{}
	}

	for _, road := range roads {
		G[road[0]] = append(G[road[0]], road[1])
		G[road[1]] = append(G[road[1]], road[0])
	}

	ANS = 0
	SEATS = int64(seats)
	dfs(0, 0)
	return ANS
}

var G [][]int
var ANS int64
var SEATS int64

func dfs(cur int, prev int) int64 {
	people := int64(1)
	for _, nxt := range G[cur] {
		if nxt == prev {
			continue
		}
		people += dfs(nxt, cur)
	}

	if cur != 0 {
		ANS += (people + SEATS - 1) / SEATS
	}
	return people
}

func main() {
	fmt.Println(minimumFuelCost([][]int{{0, 1}, {0, 2}, {0, 3}}, 5))
	fmt.Println(minimumFuelCost([][]int{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}}, 2))
	fmt.Println(minimumFuelCost([][]int{}, 1))
}
