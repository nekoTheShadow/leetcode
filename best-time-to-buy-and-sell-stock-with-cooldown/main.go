package main

import "fmt"

func main() {
	fmt.Println(maxProfit([]int{1, 2, 3, 0, 2}))
	fmt.Println(maxProfit([]int{1}))
}

func maxProfit(prices []int) int {
	PRICES = prices
	MEMO = map[Key]int{}
	return solve(0, "cooldown", false)
}

type Key struct {
	cur   int
	pre   string
	stock bool
}

var PRICES []int
var MEMO map[Key]int

func solve(cur int, pre string, stock bool) int {
	if cur == len(PRICES) {
		return 0
	}

	key := Key{cur: cur, pre: pre, stock: stock}
	if _, ok := MEMO[key]; ok {
		return MEMO[key]
	}

	if pre == "buy" {
		x := solve(cur+1, "sell", false) + PRICES[cur]
		y := solve(cur+1, "cooldown", true)
		MEMO[key] = max(x, y)
	} else if pre == "sell" {
		MEMO[key] = solve(cur+1, "cooldown", false)
	} else {
		if stock {
			x := solve(cur+1, "sell", false) + PRICES[cur]
			y := solve(cur+1, "cooldown", true)
			MEMO[key] = max(x, y)
		} else {
			x := solve(cur+1, "buy", true) - PRICES[cur]
			y := solve(cur+1, "cooldown", false)
			MEMO[key] = max(x, y)
		}
	}

	return MEMO[key]
}

func max(a, b int) int {
	if a < b {
		return b
	} else {
		return a
	}
}
