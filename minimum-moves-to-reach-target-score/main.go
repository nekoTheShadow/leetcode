package main

func minMoves(target int, maxDoubles int) int {
	if target == 1 {
		return 0
	}

	if maxDoubles == 0 {
		return target - 1
	}

	if target%2 == 0 {
		return minMoves(target/2, maxDoubles-1) + 1
	} else {
		return minMoves(target-1, maxDoubles) + 1
	}
}
