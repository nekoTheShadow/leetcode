package main

func validSequence(word1 string, word2 string) []int {
	n := len(word1)
	m := len(word2)

	// 事前計算
	last := make([]int, m)
	for i := range last {
		last[i] = -1
	}

	j := m - 1
	for i := n - 1; i >= 0; i-- {
		if j >= 0 && word1[i] == word2[j] {
			last[j] = i
			j -= 1
		}
	}

	// 貪欲法
	res := []int{}
	skipped := false
	j = 0
	for i := range n {
		if j == m {
			break
		}

		if word1[i] == word2[j] || (!skipped && (j == m-1 || i < last[j+1])) {
			if word1[i] != word2[j] {
				skipped = true
			}
			res = append(res, i)
			j++
		}
	}

	if j == m {
		return res
	} else {
		return []int{}
	}
}
