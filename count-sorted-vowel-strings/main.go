package main

import "fmt"

// func f(last int, n int) int {
// 	if n == 1 {
// 		return 1
// 	}

// 	res := 0
// 	for i := last; i < 5; i++ {
// 		res += f(i, n-1)
// 	}
// 	return res
// }

// func countVowelStrings(n int) int {
// 	res := 0
// 	for i := 0; i < 5; i++ {
// 		res += f(i, n)
// 	}
// 	return res
// }

func countVowelStrings(n int) int {
	// DP[最後の文字][何文字目]
	dp := make([][]int, 5)
	for i := 0; i < 5; i++ {
		dp[i] = make([]int, n)
	}

	for i := 0; i < 5; i++ {
		dp[i][0] = 1
	}

	for i := 0; i < 5; i++ {
		for j := 0; j < n-1; j++ {
			for k := i; k < 5; k++ {
				dp[k][j+1] += dp[i][j]
			}
		}
	}

	res := 0
	for i := 0; i < 5; i++ {
		res += dp[i][n-1]
	}
	return res
}

func main() {
	fmt.Println(countVowelStrings(1))
	fmt.Println(countVowelStrings(2))
	fmt.Println(countVowelStrings(33))
}
