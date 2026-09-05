package main

type Key struct {
	i int
	j int
}

func stoneGame(piles []int) bool {
	total := 0
	for _, pile := range piles {
		total += pile
	}
	alice := dp(piles, map[Key]int{}, 0, len(piles)-1)
	return alice > total/2
}

func dp(piles []int, memo map[Key]int, i int, j int) int {
	if i > j {
		return 0
	}

	key := Key{i: i, j: j}
	if v, ok := memo[key]; ok {
		return v
	}

	// 左端(i)を取った場合: 相手は残りの選択肢からこちらが得られるスコアを最小化してくる
	// 右端(j)を取った場合: 相手は残りの選択肢からこちらが得られるスコアを最小化してくる
	takei := piles[i] + min(dp(piles, memo, i+2, j), dp(piles, memo, i+1, j-1))
	takej := piles[j] + min(dp(piles, memo, i+1, j-1), dp(piles, memo, i, j-2))
	memo[key] = max(takei, takej)
	return memo[key]
}
