package main

import "testing"

func TestLongestSubsequence(t *testing.T) {
	tests := []struct {
		nums   []int
		output int
	}{
		{nums: []int{1, 2, 3}, output: 2},
		{nums: []int{2, 3, 4}, output: 3},
	}
	for _, tt := range tests {
		if got := longestSubsequence(tt.nums); got != tt.output {
			t.Errorf("nums=%v: expected=%v, but actual=%v", tt.nums, tt.output, got)
		}
	}
}
