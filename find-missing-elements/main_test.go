package main

import (
	"slices"
	"testing"
)

func Test_findMissingElements(t *testing.T) {
	tests := []struct {
		nums   []int
		output []int
	}{
		{nums: []int{1, 4, 2, 5}, output: []int{3}},
		{nums: []int{7, 8, 6, 9}, output: []int{}},
		{nums: []int{5, 1}, output: []int{2, 3, 4}},
	}
	for _, test := range tests {
		if got := findMissingElements(test.nums); !slices.Equal(got, test.output) {
			t.Errorf("findMissingElements(%v)=%v, but expected %v", test.nums, got, test.output)
		}
	}
}
