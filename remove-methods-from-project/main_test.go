package main

import (
	"encoding/json"
	"slices"
	"testing"
)

func TestRemainingMethods(t *testing.T) {
	tests := []struct {
		n           int
		k           int
		invocations string
		output      []int
	}{
		{n: 4, k: 1, invocations: "[[1,2],[0,1],[3,2]]", output: []int{0, 1, 2, 3}},
		{n: 5, k: 0, invocations: "[[1,2],[0,2],[0,1],[3,4]]", output: []int{3, 4}},
		{n: 3, k: 2, invocations: "[[1,2],[0,1],[2,0]]", output: []int{}},
	}
	for _, test := range tests {
		if got := remainingMethods(test.n, test.k, ToMatrix(test.invocations)); !slices.Equal(got, test.output) {
			t.Errorf("n=%v, k=%v, invocations=%v : expected=%v, but actual=%v", test.n, test.k, test.invocations, test.output, got)
		}
	}
}

func ToMatrix(s string) [][]int {
	var matrix [][]int
	err := json.Unmarshal([]byte(s), &matrix)
	if err != nil {
		panic(err)
	}
	return matrix
}
