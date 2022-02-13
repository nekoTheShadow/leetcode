package main

func numberOfArrays(differences []int, lower int, upper int) int {
	a := 0
	max := 0
	min := 0
	for _, difference := range differences {
		a += difference
		if max < a {
			max = a
		}
		if a < min {
			min = a
		}
	}

	ans := (upper - lower) - (max - min) + 1
	if ans > 0 {
		return ans
	} else {
		return 0
	}
}
