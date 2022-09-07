package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func tree2str(root *TreeNode) string {
	if root.Left == nil && root.Right == nil {
		return fmt.Sprint(root.Val)
	} else if root.Left != nil && root.Right == nil {
		return fmt.Sprintf("%v(%v)", root.Val, tree2str(root.Left))
	} else if root.Left == nil && root.Right != nil {
		return fmt.Sprintf("%v()(%v)", root.Val, tree2str(root.Right))
	} else {
		return fmt.Sprintf("%v(%v)(%v)", root.Val, tree2str(root.Left), tree2str(root.Right))
	}
}
