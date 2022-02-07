package main

func mostPoints(questions [][]int) int64 {
	return int64((&Solver{questions: questions, memo: map[int]int{}}).solve(0))
}

type Solver struct {
	questions [][]int
	memo      map[int]int
}

func (s *Solver) solve(cur int) int {
	if len(s.questions) <= cur {
		return 0
	}

	if v, ok := s.memo[cur]; ok {
		return v
	}

	a := s.questions[cur][0] + s.solve(cur+s.questions[cur][1]+1)
	b := s.solve(cur + 1)

	if a < b {
		s.memo[cur] = b
	} else {
		s.memo[cur] = a
	}
	return s.memo[cur]
}
