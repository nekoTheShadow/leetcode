package main

import (
	"testing"
)

func TestSmallestPalindrome(t *testing.T) {
	tests := []struct {
		s      string
		output string
	}{
		{
			s:      "z",
			output: "z",
		},
		{
			s:      "babab",
			output: "abbba",
		},
		{
			s:      "daccad",
			output: "acddca",
		},
	}
	for _, tt := range tests {
		if got := smallestPalindrome(tt.s); got != tt.output {
			t.Errorf("smallestPalindrome(%v) = %v, want %v", tt.s, got, tt.output)
		}
	}
}
