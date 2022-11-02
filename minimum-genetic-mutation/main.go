package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(minMutation("AACCGGTT", "AACCGGTA", []string{"AACCGGTA"}))
	fmt.Println(minMutation("AACCGGTT", "AAACGGTA", []string{"AACCGGTA", "AACCGCTA", "AAACGGTA"}))
	fmt.Println(minMutation("AAAAACCC", "AACCCCCC", []string{"AAAACCCC", "AAACCCCC", "AACCCCCC"}))
}

func minMutation(start string, end string, bank []string) int {
	words := []string{start}
	words = append(words, bank...)

	G = make([][]int, len(words))
	for i := 0; i < len(words); i++ {
		G[i] = []int{}
	}
	for i := 0; i < len(words); i++ {
		for j := i + 1; j < len(words); j++ {
			if isConnected(words[i], words[j]) {
				G[i] = append(G[i], j)
				G[j] = append(G[j], i)
			}
		}
	}

	D = make([]int, len(words))
	for i := 0; i < len(words); i++ {
		D[i] = INF
	}
	D[0] = 0

	dfs(0, -1)
	for i, word := range words {
		if word == end && D[i] != INF {
			return D[i]
		}
	}
	return -1

}

func dfs(cur int, prev int) {
	for _, nxt := range G[cur] {
		if nxt == prev {
			continue
		}
		if D[cur]+1 < D[nxt] {
			D[nxt] = D[cur] + 1
			dfs(nxt, cur)
		}
	}
}

var G [][]int
var D []int

const INF = math.MaxInt/2 - 1

func isConnected(word1, word2 string) bool {
	c := 0
	for i := 0; i < 8; i++ {
		if word1[i] != word2[i] {
			c++
		}
	}
	return c == 1
}
