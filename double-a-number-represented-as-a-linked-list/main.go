package main

import "fmt"

func doubleIt(head *ListNode) *ListNode {
	stack := []*ListNode{}
	for node := head; node != nil; node = node.Next {
		stack = append(stack, node)
	}

	a := 0
	for i := len(stack) - 1; i >= 0; i-- {
		stack[i].Val = a + stack[i].Val*2
		a = stack[i].Val / 10
		stack[i].Val = stack[i].Val % 10
	}

	if a == 0 {
		return stack[0]
	} else {
		return &ListNode{Val: a, Next: stack[0]}
	}
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func buildNode(vals []int) *ListNode {
	nodes := []*ListNode{}
	for _, val := range vals {
		nodes = append(nodes, &ListNode{Val: val})
	}
	for i := 0; i < len(nodes)-1; i++ {
		nodes[i].Next = nodes[i+1]
	}
	return nodes[0]
}

func printNode(root *ListNode) {
	vals := []int{}
	for ; root != nil; root = root.Next {
		vals = append(vals, root.Val)
	}
	fmt.Println(vals)
}

func main() {
	printNode(doubleIt(buildNode([]int{1, 8, 9})))
	printNode(doubleIt(buildNode([]int{9, 9, 9})))
}
