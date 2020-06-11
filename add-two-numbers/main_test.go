package main

import (
	"reflect"
	"testing"
)

func TestExample(t *testing.T) {
	tests := []struct {
		l1       []int
		l2       []int
		expected []int
	}{
		{
			l1:       []int{2, 4, 3},
			l2:       []int{5, 6, 4},
			expected: []int{7, 0, 8},
		},
		{
			l1:       []int{1, 8},
			l2:       []int{0},
			expected: []int{1, 8},
		},
		{
			l1:       []int{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			l2:       []int{5, 6, 4},
			expected: []int{6, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
		},
	}

	for _, test := range tests {
		n1 := toListNode(test.l1)
		n2 := toListNode(test.l2)
		actual := toSlice(addTwoNumbers(n1, n2))
		if !reflect.DeepEqual(test.expected, actual) {
			t.Errorf("addTwoNumbers(%v, %v): expected: %v, actual: %v", test.l1, test.l2, test.expected, actual)
		}
	}
}

func toListNode(digits []int) *ListNode {
	nodes := []*ListNode{}
	for _, digit := range digits {
		nodes = append(nodes, &ListNode{Val: digit})
	}
	for i := 0; i < len(nodes)-1; i++ {
		nodes[i].Next = nodes[i+1]
	}
	return nodes[0]
}

func toSlice(node *ListNode) []int {
	digits := []int{}
	for ; node != nil; node = node.Next {
		digits = append(digits, node.Val)
	}
	return digits
}
