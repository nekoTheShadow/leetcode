package main

import "testing"

func TestMinOperations(t *testing.T) {
	tests := []struct {
		nums     []int
		expected int
	}{
		{nums: []int{2, 3, 3, 2, 2, 4, 2, 3, 4}, expected: 4},
		{nums: []int{2, 1, 2, 2, 3, 3}, expected: -1},
		{nums: []int{14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12}, expected: 7},
	}
	for _, test := range tests {
		actual := minOperations(test.nums)
		if actual != test.expected {
			t.Errorf("minOperations(%v): expected: %v, actual: %v", test.nums, test.expected, actual)
		}
	}
}
