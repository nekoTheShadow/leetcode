package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func middleNode(head *ListNode) *ListNode {
	fast := head
	slow := head

	for fast.Next != nil {
		fast = fast.Next
		if fast.Next != nil {
			fast = fast.Next
		}
		slow = slow.Next
	}

	return slow
}

func run(vals []int) {
	nodes := []*ListNode{}
	for _, val := range vals {
		nodes = append(nodes, &ListNode{Val: val})
	}
	for i := 0; i < len(nodes)-1; i++ {
		nodes[i].Next = nodes[i+1]
	}

	ret := middleNode(nodes[0])
	ans := []int{}
	for ret != nil {
		ans = append(ans, ret.Val)
		ret = ret.Next
	}
	fmt.Println(ans)
}

func main() {
	run([]int{1, 2, 3, 4, 5})
	run([]int{1, 2, 3, 4, 5, 6})

	run([]int{1})
	run([]int{1, 2})
}
