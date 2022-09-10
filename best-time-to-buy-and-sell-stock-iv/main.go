package main

import "fmt"

func main() {
	fmt.Println(maxProfit(2, []int{2, 4, 1}))
	fmt.Println(maxProfit(2, []int{3, 2, 6, 5, 0, 3}))
	fmt.Println(maxProfit(11, []int{48, 12, 60, 93, 97, 42, 25, 64, 17, 56, 85, 93, 9, 48, 52, 42, 58, 85, 81, 84, 69, 36, 1, 54, 23, 15, 72, 15, 11, 94}))
}

func maxProfit(k int, prices []int) int {
	PRICES = prices
	MEMO = map[Key]int{}
	return f(k, 0, false)
}

type Key struct {
	k     int
	cur   int
	stock bool
}

var PRICES []int
var MEMO map[Key]int

func f(k int, cur int, stock bool) int {

	if k == 0 || len(PRICES) == cur {
		return 0
	}

	key := Key{k, cur, stock}
	if v, ok := MEMO[key]; ok {
		return v
	}

	v1 := f(k, cur+1, stock) // 何もしない
	var v2 int
	if stock {
		// 売却
		v2 = f(k-1, cur+1, false) + PRICES[cur]

	} else {
		// 購入
		v2 = f(k, cur+1, true) - PRICES[cur]
	}

	if v1 > v2 {
		MEMO[key] = v1
	} else {
		MEMO[key] = v2
	}
	return MEMO[key]
}
