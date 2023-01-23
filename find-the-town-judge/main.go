package main

import "fmt"

func findJudge(n int, trust [][]int) int {
	a := make([]int, n)
	b := make([]int, n)
	for _, t := range trust {
		a[t[0]-1]++
		b[t[1]-1]++
	}

	ans := []int{}
	for i := 0; i < n; i++ {
		if a[i] == 0 && b[i] == n-1 {
			ans = append(ans, i)
		}
	}

	if len(ans) == 1 {
		return ans[0] + 1
	} else {
		return -1
	}
}

func main() {
	fmt.Println(findJudge(2, [][]int{{1, 2}}))
	fmt.Println(findJudge(3, [][]int{{1, 3}, {2, 3}}))
	fmt.Println(findJudge(3, [][]int{{1, 3}, {2, 3}, {3, 1}}))
}
