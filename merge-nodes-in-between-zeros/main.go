package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeNodes(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}

	sum := 0
	cur := head.Next
	for cur.Val != 0 {
		sum += cur.Val
		cur = cur.Next
	}

	return &ListNode{Val: sum, Next: mergeNodes(cur)}
}

func main() {
	printListNode(mergeNodes(makeListNode([]int{0, 3, 1, 0, 4, 5, 2, 0})))
	printListNode(mergeNodes(makeListNode([]int{0, 1, 0, 3, 0, 2, 2, 0})))
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
