package main

import (
	"testing"
)

func TestExample(t *testing.T) {
	tests := []struct {
		grid     [][]int
		expected int
	}{
		{grid: [][]int{{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}}, expected: 3},
		{grid: [][]int{{1, 1, 3}, {3, 2, 2}, {1, 1, 4}}, expected: 0},
		{grid: [][]int{{1, 2}, {4, 3}}, expected: 1},
		{grid: [][]int{{2, 2, 2}, {2, 2, 2}}, expected: 3},
		{grid: [][]int{{4}}, expected: 0},
	}

	for _, test := range tests {
		actual := minCost(test.grid)
		if test.expected != actual {
			t.Errorf("grid=%v, expected=%v, actual=%v", test.grid, test.expected, actual)
		}
	}
}

// Input: grid = [[1,2],[4,3]]
// Output: 1

// Example 4:

// Input: grid = [[2,2,2],[2,2,2]]
// Output: 3

// Example 5:

// Input: grid = [[4]]
// Output: 0
