package main

import "testing"

func TestExample(t *testing.T) {
	tests := []struct {
		name       string
		target     int
		maxDoubles int
		expected   int
	}{
		{name: "Example1", target: 5, maxDoubles: 0, expected: 4},
		{name: "Example2", target: 19, maxDoubles: 2, expected: 7},
		{name: "Example3", target: 10, maxDoubles: 4, expected: 4},
		{name: "Example138", target: 999999998, maxDoubles: 0, expected: 999999997},
	}

	for _, test := range tests {
		actual := minMoves(test.target, test.maxDoubles)
		if actual != test.expected {
			t.Errorf("%v ... expected: %v, actual: %v", test.name, test.expected, actual)
		}
	}
}
