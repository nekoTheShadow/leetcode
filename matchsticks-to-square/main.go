package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(makesquare([]int{1, 1, 2, 2, 2}))
	fmt.Println(makesquare([]int{3, 3, 3, 3, 4}))
	fmt.Println(makesquare([]int{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6}))
}

func makesquare(matchsticks []int) bool {
	tot := 0
	for _, matcmatchstick := range matchsticks {
		tot += matcmatchstick
	}
	if tot%4 != 0 {
		return false
	}

	sort.Ints(matchsticks)
	for i := 0; i < len(matchsticks)/2; i++ {
		matchsticks[i], matchsticks[len(matchsticks)-i-1] = matchsticks[len(matchsticks)-i-1], matchsticks[i]
	}

	v := tot / 4
	return dfs(matchsticks, 0, v, v, v, v)
}

func dfs(matchsticks []int, cur int, v1 int, v2 int, v3 int, v4 int) bool {
	if len(matchsticks) == cur {
		return true
	}
	return ((v1-matchsticks[cur] >= 0) && dfs(matchsticks, cur+1, v1-matchsticks[cur], v2, v3, v4)) ||
		((v2-matchsticks[cur] >= 0) && dfs(matchsticks, cur+1, v1, v2-matchsticks[cur], v3, v4)) ||
		((v3-matchsticks[cur] >= 0) && dfs(matchsticks, cur+1, v1, v2, v3-matchsticks[cur], v4)) ||
		((v4-matchsticks[cur] >= 0) && dfs(matchsticks, cur+1, v1, v2, v3, v4-matchsticks[cur]))
}
