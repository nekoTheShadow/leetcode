package main

import "math"

func minDifficulty(jobDifficulty []int, d int) int {
	return NewSolver(jobDifficulty, d).Solve()
}

type Solver struct {
	jobDifficulty []int
	d             int
	memo          map[entry]int
}

type entry struct {
	x int
	e int
}

func NewSolver(jobDifficulty []int, d int) *Solver {
	solver := &Solver{jobDifficulty: jobDifficulty, d: d}
	solver.memo = map[entry]int{}
	return solver
}

func (solver *Solver) Solve() int {
	ans := solver.f(0, solver.d)
	if ans == INFINITY {
		return -1
	} else {
		return ans
	}
}

func (solver *Solver) f(x int, e int) int {
	key := entry{x: x, e: e}
	if _, ok := solver.memo[key]; ok {
		return solver.memo[key]
	}

	if len(solver.jobDifficulty)-x < e {
		return INFINITY
	}

	if e == 0 {
		if x == len(solver.jobDifficulty) {
			return 0
		} else {
			return INFINITY
		}
	}

	ans := INFINITY
	max := solver.jobDifficulty[x]
	for i := x; i < len(solver.jobDifficulty); i++ {
		max = Max(max, solver.jobDifficulty[i])
		ans = Min(ans, max+solver.f(i+1, e-1))
	}

	solver.memo[key] = ans
	return ans
}

// === MY LIBRARY ===

const INFINITY = math.MaxInt64/2 - 1

func Min(a int, b ...int) int {
	for _, v := range b {
		if v < a {
			a = v
		}
	}
	return a
}

func Max(a int, b ...int) int {
	for _, v := range b {
		if a < v {
			a = v
		}
	}
	return a
}
