package main

import "testing"

func TestExample(t *testing.T) {
	tests := []struct {
		plantTime []int
		growTime  []int
		expected  int
	}{
		{
			plantTime: []int{1, 2, 3, 2},
			growTime:  []int{2, 1, 2, 1},
			expected:  9,
		},
		{
			plantTime: []int{1, 4, 3},
			growTime:  []int{2, 3, 1},
			expected:  9,
		},
		{
			plantTime: []int{1},
			growTime:  []int{1},
			expected:  2,
		},
	}

	for _, test := range tests {
		actual := earliestFullBloom(test.plantTime, test.growTime)
		if actual != test.expected {
			t.Errorf("earliestFullBloom(plantTime=%v, growTime=%v) ... expected: %v, actual: %v", test.plantTime, test.growTime, test.expected, actual)
		}
	}

}
