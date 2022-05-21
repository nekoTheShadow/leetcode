package main

import (
	"fmt"
	"math"
)

var COINS []int
var INF int
var MEMO [][]int

func coinChange(coins []int, amount int) int {
	COINS = coins
	INF = math.MaxInt/2 - 1
	MEMO = make([][]int, len(COINS))
	for i := 0; i < len(COINS); i++ {
		MEMO[i] = make([]int, amount+1)
		for j := 0; j < len(MEMO[i]); j++ {
			MEMO[i][j] = -1
		}
	}

	v := dfs(0, amount)
	if v < INF {
		return v
	} else {
		return -1
	}
}

func dfs(cur int, amount int) int {
	if amount == 0 {
		return 0
	}

	if amount < 0 || len(COINS) == cur {
		return INF
	}

	if MEMO[cur][amount] != -1 {
		return MEMO[cur][amount]
	}

	ret := INF
	for i := 0; i <= amount/COINS[cur]; i++ {
		v := dfs(cur+1, amount-COINS[cur]*i) + i
		if v < ret {
			ret = v
		}
	}

	MEMO[cur][amount] = ret
	return ret
}

func main() {
	fmt.Println(coinChange([]int{1, 2, 5}, 11))
	fmt.Println(coinChange([]int{2}, 3))
	fmt.Println(coinChange([]int{1}, 0))
	fmt.Println(coinChange([]int{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422}, 9864))
	fmt.Println(coinChange([]int{176, 6, 366, 357, 484, 226, 1, 104, 160, 331}, 5557))
}
