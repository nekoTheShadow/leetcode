package main

import "testing"

func TestExample(t *testing.T) {
	tests := []struct {
		graph    [][]int
		expected int
	}{
		{graph: [][]int{{1, 2, 3}, {0}, {0}, {0}}, expected: 4},
		{graph: [][]int{{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}}, expected: 4},
	}

	for _, test := range tests {
		actual := shortestPathLength(test.graph)
		if actual != test.expected {
			t.Errorf("shortestPathLength(graph=%v): expected %v, actual %v", test.graph, test.expected, actual)
		}
	}
}
