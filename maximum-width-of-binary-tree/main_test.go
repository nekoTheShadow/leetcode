package main

import (
	"fmt"
	"testing"
)

func TestWidthOfBinaryTree(t *testing.T) {
	tests := []struct {
		name     string
		vals     []int
		expected int
	}{
		{name: "Example1", vals: []int{1, 3, 2, 5, 3, -1, 9}, expected: 4},
		{name: "Example2", vals: []int{1, 3, -1, 5, 3}, expected: 2},
		{name: "Example3", vals: []int{1, 3, 2, 5}, expected: 2},
	}

	for _, test := range tests {
		root := makeTree(test.vals)
		actual := widthOfBinaryTree(root)
		if actual != test.expected {
			t.Errorf("%v ... expected: %v, actual: %v", test.name, test.expected, actual)
		}
	}
}

func makeTree(vals []int) *TreeNode {
	nodes := []*TreeNode{}
	for _, val := range vals {
		nodes = append(nodes, &TreeNode{Val: val})
	}

	for i := 0; i < len(nodes); i++ {
		if nodes[i].Val == -1 {
			continue
		}

		if 2*i+1 < len(nodes) && nodes[2*i+1].Val != -1 {
			nodes[i].Left = nodes[2*i+1]
		}
		if 2*i+2 < len(nodes) && nodes[2*i+2].Val != -1 {
			nodes[i].Right = nodes[2*i+2]
		}
		fmt.Println(nodes[i])
	}
	return nodes[0]
}
