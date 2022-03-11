package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil {
		return nil
	}

	lst := head
	size := 1
	for lst.Next != nil {
		size++
		lst = lst.Next
	}
	k = k % size

	if k == 0 {
		return head
	}

	a := head
	for x := 0; x < size-k-1; x++ {
		a = a.Next
	}
	ans := a.Next
	a.Next = nil

	lst.Next = head
	return ans
}

func main() {
	printListNode(rotateRight(makeListNode([]int{1, 2, 3, 4, 5}), 2))
	printListNode(rotateRight(makeListNode([]int{0, 1, 2}), 4))
	printListNode(rotateRight(makeListNode([]int{0, 1, 2}), 2))
}

func makeListNode(vals []int) *ListNode {
	nodes := []*ListNode{}
	for _, val := range vals {
		nodes = append(nodes, &ListNode{Val: val})
	}
	for i := 0; i < len(nodes)-1; i++ {
		nodes[i].Next = nodes[i+1]
	}
	return nodes[0]
}

func printListNode(head *ListNode) {
	vals := []int{}
	for head != nil {
		vals = append(vals, head.Val)
		head = head.Next
	}
	fmt.Println(vals)
}
