package main

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {
	if head == nil {
		return head
	}

	cur := head
	for cur != nil {
		nxt := cur.Next
		cur.Next = &Node{Val: cur.Val, Next: nxt}
		cur = nxt
	}

	cur = head
	for cur != nil {
		if cur.Random != nil {
			cur.Next.Random = cur.Random.Next
		}
		cur = cur.Next.Next
	}

	cur1 := head
	cur2 := head.Next
	ans := head.Next
	for cur1 != nil && cur2 != nil {
		cur1.Next = cur1.Next.Next
		if cur2.Next != nil {
			cur2.Next = cur2.Next.Next
		}
		cur1 = cur1.Next
		cur2 = cur2.Next
	}

	return ans
}
