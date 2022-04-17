package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func increasingBST(root *TreeNode) *TreeNode {
	prev = nil
	head = nil
	solve(root)
	return head
}

var prev *TreeNode
var head *TreeNode

func solve(root *TreeNode) {
	if root == nil {
		return
	}

	solve(root.Left)
	if prev != nil {
		root.Left = nil
		prev.Right = root
	}

	if head == nil {
		head = root
	}

	prev = root
	solve(root.Right)
}
