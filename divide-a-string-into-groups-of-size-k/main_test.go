package main

import (
	"reflect"
	"testing"
)

func TestExample(t *testing.T) {
	tests := []struct {
		name     string
		s        string
		k        int
		fill     byte
		expected []string
	}{
		{name: "example1", s: "abcdefghi", k: 3, fill: 'x', expected: []string{"abc", "def", "ghi"}},
		{name: "example2", s: "abcdefghij", k: 3, fill: 'x', expected: []string{"abc", "def", "ghi", "jxx"}},
	}

	for _, test := range tests {
		actual := divideString(test.s, test.k, test.fill)
		if !reflect.DeepEqual(actual, test.expected) {
			t.Errorf("%v: expected: %v, actual: %v", test.name, test.expected, actual)
		}
	}
}
