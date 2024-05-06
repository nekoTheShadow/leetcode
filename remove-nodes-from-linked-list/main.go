package main

import "fmt"

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNodes(head *ListNode) *ListNode {
	stack := []*ListNode{}

	for ; head != nil; head = head.Next {
		for len(stack) > 0 && stack[len(stack)-1].Val < head.Val {
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, head)
	}

	if len(stack) == 0 {
		return nil
	}

	for i := 0; i < len(stack)-1; i++ {
		stack[i].Next = stack[i+1]
	}
	stack[len(stack)-1].Next = nil
	return stack[0]
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
	printNode(removeNodes(buildNode([]int{5, 2, 13, 3, 8})))
	printNode(removeNodes(buildNode([]int{1, 1, 1, 1})))
}
