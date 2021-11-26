package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	size := 0
	for listNode := head; listNode != nil; listNode = listNode.Next {
		size++
	}

	if n == size {
		return head.Next
	}

	listNode := head
	for i := 0; i < size-n-1; i++ {
		listNode = listNode.Next
	}
	listNode.Next = listNode.Next.Next

	return head
}
