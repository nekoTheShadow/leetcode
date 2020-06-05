package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func postorderTraversal(root *TreeNode) []int {
	a := []int{}

	if root == nil {
		return a
	}

	if root.Left != nil {
		a = append(a, postorderTraversal(root.Left)...)
	}
	if root.Right != nil {
		a = append(a, postorderTraversal(root.Right)...)
	}
	a = append(a, root.Val)
	return a
}
