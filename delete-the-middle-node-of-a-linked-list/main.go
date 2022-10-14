package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteMiddle(head *ListNode) *ListNode {
	n := 0
	cur1 := head
	for cur1 != nil {
		n++
		cur1 = cur1.Next
	}

	if n == 1 {
		return nil
	}
	if n == 2 {
		head.Next = nil
		return head
	}

	cur2 := head
	for i := 0; i < n/2-1; i++ {
		cur2 = cur2.Next
	}

	cur2.Next = cur2.Next.Next
	return head
}
