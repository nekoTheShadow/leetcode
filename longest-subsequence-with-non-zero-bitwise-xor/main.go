package main

func longestSubsequence(nums []int) int {
	totalXor := 0
	allZero := true
	for _, v := range nums {
		totalXor ^= v
		if v != 0 {
			allZero = false
		}
	}

	// 配列全体のxorが0ではない場合、配列全体が回答になる
	n := len(nums)
	if totalXor != 0 {
		return n
	}

	// 配列全体のxorが0の場合
	// - 配列の要素すべてが0の場合、条件を満たす部分列は存在しない
	// - 配列に0以外の要素がある場合、先頭もしくは最後尾を取り除けばよい
	if allZero {
		return 0
	} else {
		return n - 1
	}
}
