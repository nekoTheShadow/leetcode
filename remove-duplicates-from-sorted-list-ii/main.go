package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}

	c := 0
	cur := head
	for cur != nil && head.Val == cur.Val {
		cur = cur.Next
		c++
	}

	if c == 1 {
		head.Next = deleteDuplicates(cur)
		return head
	} else {
		return deleteDuplicates(cur)
	}
}

func main() {
	printListNode(deleteDuplicates(makeListNode([]int{1, 2, 3, 3, 4, 4, 5})))
	printListNode(deleteDuplicates(makeListNode([]int{1, 1, 1, 2, 3})))
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
