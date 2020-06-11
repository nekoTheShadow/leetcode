package main

import (
	"strings"
)

func shortestCommonSupersequence(str1 string, str2 string) string {
	lcs := LCS(str1, str2)
	x := 0
	y := 0
	s := []rune(str1)
	t := []rune(str2)
	var ans strings.Builder
	for _, ch := range lcs {
		for s[x] != ch {
			ans.WriteRune(s[x])
			x++
		}
		for t[y] != ch {
			ans.WriteRune(t[y])
			y++
		}
		ans.WriteRune(ch)
		x++
		y++
	}

	ans.WriteString(str1[x:])
	ans.WriteString(str2[y:])
	return ans.String()
}

func LCS(s, t string) string {
	n := len(s)
	m := len(t)
	dp := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, m+1)
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			if s[i-1] == t[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = Max(dp[i-1][j], dp[i][j-1])
			}
		}
	}

	x := n
	y := m
	u := make([]byte, dp[n][m])
	i := dp[n][m] - 1
	for x > 0 && y > 0 {
		if dp[x][y] == dp[x-1][y] {
			x--
		} else if dp[x][y] == dp[x][y-1] {
			y--
		} else {
			x--
			y--
			u[i] = s[x]
			i--
		}
	}

	return string(u)
}

func Max(a int, b ...int) int {
	for _, v := range b {
		if a < v {
			a = v
		}
	}
	return a
}
