package main

import "testing"

func TestMostPoints(t *testing.T) {
	tests := []struct {
		name      string
		questions [][]int
		expected  int64
	}{
		{name: "example1", questions: [][]int{{3, 2}, {4, 3}, {4, 4}, {2, 5}}, expected: 5},
		{name: "example2", questions: [][]int{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}, expected: 7},
	}

	for _, test := range tests {
		actual := mostPoints(test.questions)
		if actual != test.expected {
			t.Errorf("%v ... expected: %v, actual: %v", test.name, test.expected, actual)
		}
	}
}
