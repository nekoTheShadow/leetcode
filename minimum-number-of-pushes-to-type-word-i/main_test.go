package main

import "testing"

func TestMinimumPushes(t *testing.T) {
	tests := []struct {
		word   string
		output int
	}{{
		word:   "abcde",
		output: 5,
	}, {
		word:   "xycdefghij",
		output: 12,
	}}

	for _, tt := range tests {
		if got := minimumPushes(tt.word); got != tt.output {
			t.Errorf("minimumPushes(%v) = %v, but expected %v", tt.word, got, tt.output)
		}
	}
}
