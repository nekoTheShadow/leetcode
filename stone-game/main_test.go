package main

import "testing"

func TestStoneGame(t *testing.T) {
	tests := []struct {
		piles  []int
		output bool
	}{
		{piles: []int{5, 3, 4, 5}, output: true},
		{piles: []int{3, 7, 2, 3}, output: true},
	}
	for _, tt := range tests {
		if got := stoneGame(tt.piles); got != tt.output {
			t.Errorf("stoneGame(%v) = %v, but expected %v", tt.piles, got, tt.output)
		}
	}
}
