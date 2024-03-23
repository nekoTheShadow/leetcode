package main

import (
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func reorderList(head *ListNode) {
	nodes1 := []*ListNode{}
	cur := head
	for cur != nil {
		nodes1 = append(nodes1, cur)
		cur = cur.Next
	}

	nodes2 := []*ListNode{}
	n := len(nodes1)
	for i := 0; i <= n/2; i++ {
		nodes2 = append(nodes2, nodes1[i])
		nodes2 = append(nodes2, nodes1[n-i-1])
	}
	for i := 0; i < n-1; i++ {
		nodes2[i].Next = nodes2[i+1]
	}
	nodes2[n-1].Next = nil
	*head = *nodes2[0]
}

func main() {
	example1()
	example2()
}

func example1() {
	head := toList([]int{1, 2, 3, 4})
	reorderList(head)
	fmt.Println(toSlice(head))
}

func example2() {
	head := toList([]int{1, 2, 3, 4, 5})
	reorderList(head)
	fmt.Println(toSlice(head))
}

func toList(vals []int) *ListNode {
	nodes := []*ListNode{}
	for _, val := range vals {
		nodes = append(nodes, &ListNode{Val: val})
	}
	for i := 0; i < len(vals)-1; i++ {
		nodes[i].Next = nodes[i+1]
	}
	return nodes[0]
}

func toSlice(head *ListNode) []int {
	vals := []int{}
	cur := head
	for cur != nil {
		vals = append(vals, cur.Val)
		cur = cur.Next
	}
	return vals
}
