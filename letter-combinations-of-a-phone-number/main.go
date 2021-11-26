package main

func letterCombinations(digits string) []string {
	if digits == "" {
		return []string{}
	}

	d := map[rune][]string{
		[]rune("2")[0]: {"a", "b", "c"},
		[]rune("3")[0]: {"d", "e", "f"},
		[]rune("4")[0]: {"g", "h", "i"},
		[]rune("5")[0]: {"j", "k", "l"},
		[]rune("6")[0]: {"m", "n", "o"},
		[]rune("7")[0]: {"p", "q", "r", "s"},
		[]rune("8")[0]: {"t", "u", "v"},
		[]rune("9")[0]: {"w", "x", "y", "z"},
	}

	words := []string{""}
	for _, digit := range digits {
		nexts := []string{}
		for _, word := range words {
			for _, tail := range d[digit] {
				nexts = append(nexts, word+tail)
			}
		}
		words = nexts
	}
	return words
}
