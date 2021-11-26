package main

import (
	"reflect"
	"testing"
)

func TestRemoveNthFromEnd(t *testing.T) {
	tests := []struct {
		vals []int
		n    int
		want []int
	}{
		{
			vals: []int{1, 2, 3, 4, 5},
			n:    2,
			want: []int{1, 2, 3, 5},
		},
		{
			vals: []int{1},
			n:    1,
			want: []int{},
		},
		{
			vals: []int{1, 2},
			n:    1,
			want: []int{1},
		},
	}

	for _, tt := range tests {
		got := walkListNode(removeNthFromEnd(makeListNode(tt.vals), tt.n))
		if !reflect.DeepEqual(tt.want, got) {
			t.Errorf("removeNthFromEnd(%v, %v) ... want: %v, got: %v", tt.vals, tt.n, tt.want, got)
		}
	}
}

func makeListNode(vals []int) *ListNode {
	listNodes := []*ListNode{}
	for _, val := range vals {
		listNodes = append(listNodes, &ListNode{Val: val})
	}
	for i := 0; i < len(listNodes)-1; i++ {
		listNodes[i].Next = listNodes[i+1]
	}
	return listNodes[0]
}

func walkListNode(head *ListNode) []int {
	vals := []int{}
	for head != nil {
		vals = append(vals, head.Val)
		head = head.Next
	}
	return vals
}
