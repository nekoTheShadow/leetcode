package main

import "testing"

func TestMinSwapsCouples(t *testing.T) {
	tests := []struct {
		row      []int
		expected int
	}{
		{row: []int{0, 2, 1, 3}, expected: 1},
		{row: []int{3, 2, 0, 1}, expected: 0},
		{row: []int{5, 4, 2, 6, 3, 1, 0, 7}, expected: 2},
	}

	for _, test := range tests {
		actual := minSwapsCouples(test.row)
		if test.expected != actual {
			t.Errorf("minSwapsCouples(%v): expected: %v, actual: %v", test.row, test.expected, actual)
		}
	}
}
