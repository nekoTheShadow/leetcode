package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	root := &ListNode{}
	node := root
	digit := 0
	for {
		if l1 != nil {
			digit += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			digit += l2.Val
			l2 = l2.Next
		}

		node.Val = digit % 10
		digit /= 10
		if l1 == nil && l2 == nil && digit == 0 {
			break
		}
		node.Next = &ListNode{}
		node = node.Next
	}
	return root
}
