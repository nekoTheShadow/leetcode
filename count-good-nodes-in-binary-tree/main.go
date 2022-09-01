package main

import "math"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func goodNodes(root *TreeNode) int {
	return f(root, math.MinInt)
}

func f(cur *TreeNode, max int) int {
	c := 0
	if max <= cur.Val {
		c++
		max = cur.Val
	}

	if cur.Left != nil {
		c += f(cur.Left, max)
	}
	if cur.Right != nil {
		c += f(cur.Right, max)
	}

	return c
}
