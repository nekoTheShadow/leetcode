package main

import "testing"

func TestNumberOfArrays(t *testing.T) {
	tests := []struct {
		name        string
		differences []int
		lower       int
		upper       int
		expected    int
	}{
		{name: "example1", differences: []int{1, -3, 4}, lower: 1, upper: 6, expected: 2},
		{name: "example2", differences: []int{3, -4, 5, 1, -2}, lower: -4, upper: 5, expected: 4},
		{name: "example3", differences: []int{4, -7, 2}, lower: 3, upper: 6, expected: 0},
	}

	for _, test := range tests {
		actual := numberOfArrays(test.differences, test.lower, test.upper)
		if actual != test.expected {
			t.Errorf("%v ... expected: %v, actual: %v", test.name, test.expected, actual)
		}
	}
}
