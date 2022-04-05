package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func swapNodes(head *ListNode, k int) *ListNode {
	fast := head
	slow := head

	for i := 0; i < k-1; i++ {
		fast = fast.Next
	}
	a := fast

	for fast.Next != nil {
		fast = fast.Next
		slow = slow.Next
	}
	b := slow

	a.Val, b.Val = b.Val, a.Val
	return head
}
