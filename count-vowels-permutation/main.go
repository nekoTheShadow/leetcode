package main

func countVowelPermutation(n int) int {
	// dp[今何文字目?][今の文字種]
	dp := make([]map[rune]int, n)
	for i := 0; i < n; i++ {
		dp[i] = map[rune]int{'a': 0, 'e': 0, 'i': 0, 'o': 0, 'u': 0}
	}

	dp[0]['a'] = 1
	dp[0]['e'] = 1
	dp[0]['i'] = 1
	dp[0]['o'] = 1
	dp[0]['u'] = 1

	for i := 0; i < n-1; i++ {
		// a -> e
		dp[i+1]['e'] += dp[i]['a']

		// e -> a, i
		dp[i+1]['a'] += dp[i]['e']
		dp[i+1]['i'] += dp[i]['e']

		// i -> a, e, o, u
		dp[i+1]['a'] += dp[i]['i']
		dp[i+1]['e'] += dp[i]['i']
		dp[i+1]['o'] += dp[i]['i']
		dp[i+1]['u'] += dp[i]['i']

		// o -> i, u
		dp[i+1]['i'] += dp[i]['o']
		dp[i+1]['u'] += dp[i]['o']

		// u -> a
		dp[i+1]['a'] += dp[i]['u']

		dp[i+1]['a'] %= 1e9 + 7
		dp[i+1]['e'] %= 1e9 + 7
		dp[i+1]['i'] %= 1e9 + 7
		dp[i+1]['o'] %= 1e9 + 7
		dp[i+1]['u'] %= 1e9 + 7
	}

	sum := dp[n-1]['a'] + dp[n-1]['e'] + dp[n-1]['i'] + dp[n-1]['o'] + dp[n-1]['u']
	sum %= 1e9 + 7
	return sum
}
