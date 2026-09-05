package main

import "testing"

func TestWinnerSquareGame(t *testing.T) {
	tests := []struct {
		n      int
		output bool
	}{
		{n: 1, output: true},
		{n: 2, output: false},
		{n: 4, output: true},
	}

	for _, test := range tests {
		if got := winnerSquareGame(test.n); got != test.output {
			t.Errorf("winnerSquareGame(n=%v)=%v, but expected %v", test.n, got, test.output)
		}
	}
}
