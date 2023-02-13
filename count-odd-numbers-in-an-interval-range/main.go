package main

// 奇数-奇数: 3-7 [3, 5, 7] (7-3)/2=2(+1)
// 奇数-偶数: 3-8 [3, 5, 7] (8-3)/2=2(+1)
// 偶数-奇数: 4-7 [5, 7]    (7-4)/2=1(+1)
// 偶数-偶数: 4-8 [5, 7]    (8-4)/2=2
func countOdds(low int, high int) int {
	if low%2 == 0 && high%2 == 0 {
		return (high - low) / 2
	} else {
		return (high-low)/2 + 1
	}
}
