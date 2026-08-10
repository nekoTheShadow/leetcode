package main

var MEMO map[int]bool

func winnerSquareGame(n int) bool {
	MEMO = map[int]bool{}
	return dp(n)
}

func dp(n int) bool {
	if n == 0 {
		return false
	}

	if ret, ok := MEMO[n]; ok {
		return ret
	}

	ret := false
	for x := 1; x*x <= n; x++ {
		if !dp(n - x*x) {
			ret = true
			break
		}
	}
	MEMO[n] = ret
	return ret
}
