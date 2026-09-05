package main

import (
	"slices"
	"testing"
)

func TestValidSequence(t *testing.T) {
	tests := []struct {
		word1  string
		word2  string
		output []int
	}{
		{word1: "vbcca", word2: "abc", output: []int{0, 1, 2}},
		{word1: "bacdc", word2: "abc", output: []int{1, 2, 4}},
		{word1: "aaaaaa", word2: "aaabc", output: []int{}},
		{word1: "abc", word2: "ab", output: []int{0, 1}},
	}
	for _, test := range tests {
		if got := validSequence(test.word1, test.word2); !slices.Equal(got, test.output) {
			t.Errorf("validSequence(word1=%v, word2=%v)=%v, but expected %v", test.word1, test.word2, got, test.output)
		}
	}
}
