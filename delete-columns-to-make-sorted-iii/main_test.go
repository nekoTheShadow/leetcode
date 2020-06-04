package main

import "testing"

func TestExample(t *testing.T) {
	tests := []struct {
		A        []string
		expected int
	}{
		{
			A:        []string{"babca", "bbazb"},
			expected: 3,
		},
		{
			A:        []string{"edcba"},
			expected: 4,
		},
		{
			A:        []string{"ghi", "def", "abc"},
			expected: 0,
		},
		{
			A:        []string{"aaa", "aaa", "aaa"},
			expected: 0,
		},
		{
			A:        []string{"abbba"},
			expected: 1,
		},
	}

	for _, test := range tests {
		actual := minDeletionSize(test.A)
		if actual != test.expected {
			t.Errorf("minDeletionSize(%v): expected %v, actual %v", test.A, test.expected, actual)
		}
	}
}
