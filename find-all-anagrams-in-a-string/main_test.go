package main

import (
	"reflect"
	"testing"
)

func TestExample(t *testing.T) {
	tests := []struct {
		s        string
		p        string
		expected []int
	}{
		{s: "cbaebabacd", p: "abc", expected: []int{0, 6}},
		{s: "abab", p: "ab", expected: []int{0, 1, 2}},
		{s: "aaaaaaaaaa", p: "aaaaaaaaaaaaa", expected: []int{}},
	}

	for _, test := range tests {
		actual := findAnagrams(test.s, test.p)
		if !reflect.DeepEqual(actual, test.expected) {
			t.Errorf("findAnagrams(s=%v, p=%v): expected %v, actual: %v", test.s, test.p, test.expected, actual)
		}
	}
}
