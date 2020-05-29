package main

import "testing"

func TestMinDifficulty(t *testing.T) {
	tests := []struct {
		jobDifficulty []int
		d             int
		expected      int
	}{
		{
			jobDifficulty: []int{6, 5, 4, 3, 2, 1},
			d:             2,
			expected:      7,
		},
		{
			jobDifficulty: []int{9, 9, 9},
			d:             4,
			expected:      -1,
		},
		{
			jobDifficulty: []int{1, 1, 1},
			d:             3,
			expected:      3,
		},
		{
			jobDifficulty: []int{11, 111, 22, 222, 33, 333, 44, 444},
			d:             6,
			expected:      843,
		},
		{
			jobDifficulty: []int{380, 302, 102, 681, 863, 676, 243, 671, 651, 612, 162, 561, 394, 856, 601, 30, 6, 257, 921, 405, 716, 126, 158, 476, 889, 699, 668, 930, 139, 164, 641, 801, 480, 756, 797, 915, 275, 709, 161, 358, 461, 938, 914, 557, 121, 964, 315},
			d:             10,
			expected:      3807,
		},
	}

	for _, test := range tests {
		actual := minDifficulty(test.jobDifficulty, test.d)
		if actual != test.expected {
			t.Errorf("minDifficulty(%v, %v): expected %v, but actual %v", test.jobDifficulty, test.d, test.expected, actual)
		}
	}
}
