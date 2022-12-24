package main

import "fmt"

func numTilings(n int) int {
	MEMO1 = map[int]int{}
	MEMO2 = map[int]int{}
	return numTilings1(n)
}

var MEMO1 map[int]int
var MEMO2 map[int]int

const MOD = 1000000000 + 7

func numTilings1(n int) int {
	if n < 1 {
		return 0
	}
	if n == 1 {
		return 1
	}
	if n == 2 {
		return 2
	}

	if _, ok := MEMO1[n]; !ok {
		MEMO1[n] = (numTilings1(n-1) + numTilings1(n-2) + numTilings2(n-1) + numTilings2(n-1)) % MOD
	}
	return MEMO1[n]
}

func numTilings2(n int) int {
	if n < 2 {
		return 0
	}
	if n == 2 {
		return 1
	}

	if _, ok := MEMO2[n]; !ok {
		MEMO2[n] = (numTilings1(n-2) + numTilings2(n-1)) % MOD
	}
	return MEMO2[n]
}

func main() {
	fmt.Println(numTilings(3))
	fmt.Println(numTilings(1))
}
