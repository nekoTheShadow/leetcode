package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func oddEvenList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	odd := head
	even := head.Next

	first := odd
	second := even
	for !(first.Next == nil || first.Next.Next == nil) {
		first.Next = first.Next.Next
		second.Next = second.Next.Next

		first = first.Next
		second = second.Next
	}

	first.Next = even
	return odd
}

func run(vals []int) {
	nodes := []*ListNode{}
	for _, val := range vals {
		nodes = append(nodes, &ListNode{Val: val, Next: nil})
	}
	for i := 0; i < len(nodes)-1; i++ {
		nodes[i].Next = nodes[i+1]
	}

	head := oddEvenList(nodes[0])
	ans := []int{}
	for head != nil {
		ans = append(ans, head.Val)
		head = head.Next
	}
	fmt.Println(ans)
}

func main() {
	run([]int{1, 2, 3, 4, 5})
	run([]int{2, 1, 3, 5, 6, 4, 7})
}
