package main

import "testing"

func TestLongestCommonPrefix(t *testing.T) {
	tests := []struct {
		strs     []string
		expected string
	}{
		{
			strs:     []string{"flower", "flow", "flight"},
			expected: "fl",
		},
		{
			strs:     []string{"dog", "racecar", "car"},
			expected: "",
		},
	}

	for _, test := range tests {
		if actual := longestCommonPrefix(test.strs); actual != test.expected {
			t.Errorf("longestCommonPrefix(%v): expected: %v, acutal: %v", test.strs, test.expected, actual)
		}
	}
}
