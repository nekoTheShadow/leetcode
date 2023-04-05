package main

import (
	"testing"
)

func TestMinimizeArrayValue(t *testing.T) {
	tests := []struct {
		message  string
		nums     []int
		expected int
	}{
		{message: "Example 1", nums: []int{3, 7, 1, 6}, expected: 5},
		{message: "Example 2", nums: []int{10, 1}, expected: 10},
	}

	for _, test := range tests {
		actual := minimizeArrayValue(test.nums)
		if test.expected != actual {
			t.Errorf("[`%v`] expected: `%v`, but actual: `%v`", test.message, test.expected, actual)
		}
	}
}
