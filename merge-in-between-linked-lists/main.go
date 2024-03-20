package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeInBetween(list1 *ListNode, a int, b int, list2 *ListNode) *ListNode {
	cur1 := list1
	cur2 := list1
	for i := 0; i < a-1; i++ {
		cur1 = cur1.Next
	}
	for i := 0; i < b+1; i++ {
		cur2 = cur2.Next
	}

	cur1.Next = list2
	for cur1.Next != nil {
		cur1 = cur1.Next
	}
	cur1.Next = cur2

	return list1
}

func main() {
	a1 := mergeInBetween(sliceToListnode([]int{10, 1, 13, 6, 9, 5}), 3, 4, sliceToListnode([]int{1000000, 1000001, 1000002}))
	fmt.Println(listnodeToSlice(a1))

	a2 := mergeInBetween(sliceToListnode([]int{0, 1, 2, 3, 4, 5, 6}), 2, 5, sliceToListnode([]int{1000000, 1000001, 1000002, 1000003, 1000004}))
	fmt.Println(listnodeToSlice(a2))

}

func sliceToListnode(vals []int) *ListNode {
	nodes := []*ListNode{}
	for _, val := range vals {
		nodes = append(nodes, &ListNode{Val: val})
	}
	for i := 0; i < len(nodes)-1; i++ {
		nodes[i].Next = nodes[i+1]
	}
	return nodes[0]
}

func listnodeToSlice(node *ListNode) []int {
	vals := []int{}
	for node != nil {
		vals = append(vals, node.Val)
		node = node.Next
	}
	return vals
}
