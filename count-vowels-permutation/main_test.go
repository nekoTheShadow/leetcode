package main

import "testing"

func TestExample(t *testing.T) {
	tests := []struct {
		n        int
		expected int
	}{
		{n: 1, expected: 5},
		{n: 2, expected: 10},
		{n: 5, expected: 68},
	}
	for _, test := range tests {
		actual := countVowelPermutation(test.n)
		if actual != test.expected {
			t.Errorf("countVowelPermutation(n=%v): expected %v, actual %v", test.n, test.expected, actual)
		}
	}
}
