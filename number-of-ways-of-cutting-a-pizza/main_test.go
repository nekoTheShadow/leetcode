package main

import (
	"testing"
)

func TestWays(t *testing.T) {
	tests := []struct {
		pizza    []string
		k        int
		expected int
	}{
		{pizza: []string{"A..", "AAA", "..."}, k: 3, expected: 3},
		{pizza: []string{"A..", "AA.", "..."}, k: 3, expected: 1},
		{pizza: []string{"A..", "AAA", "..."}, k: 1, expected: 1},
	}

	for _, test := range tests {
		actual := ways(test.pizza, test.k)
		if actual != test.expected {
			t.Errorf("ways(pizza=%v, k=%v): expected=%v, actual=%v", test.pizza, test.k, test.expected, actual)
		}
	}
}
