package main

import (
	"fmt"
	"math"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func nodesBetweenCriticalPoints(head *ListNode) []int {
	var pre *ListNode
	cur := head
	index := 0
	indexes := []int{}
	for cur != nil {
		if pre != nil && cur.Next != nil && ((pre.Val < cur.Val && cur.Val > cur.Next.Val) || (pre.Val > cur.Val && cur.Val < cur.Next.Val)) {
			indexes = append(indexes, index)
		}

		index++
		pre = cur
		cur = cur.Next
	}

	if len(indexes) < 2 {
		return []int{-1, -1}
	}

	maxdist := indexes[len(indexes)-1] - indexes[0]
	mindist := math.MaxInt
	for i := 0; i < len(indexes)-1; i++ {
		if indexes[i+1]-indexes[i] < mindist {
			mindist = indexes[i+1] - indexes[i]
		}
	}
	return []int{mindist, maxdist}
}

func main() {
	fmt.Println(nodesBetweenCriticalPoints(build([]int{3, 1})))
	fmt.Println(nodesBetweenCriticalPoints(build([]int{5, 3, 1, 2, 5, 1, 2})))
	fmt.Println(nodesBetweenCriticalPoints(build([]int{1, 3, 2, 2, 3, 2, 2, 2, 7})))
}

func build(vals []int) *ListNode {
	nodes := []*ListNode{}
	for _, val := range vals {
		nodes = append(nodes, &ListNode{Val: val})
	}
	for i := 0; i < len(nodes)-1; i++ {
		nodes[i].Next = nodes[i+1]
	}
	return nodes[0]
}
