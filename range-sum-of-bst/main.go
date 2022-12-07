package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func rangeSumBST(root *TreeNode, low int, high int) int {
	if root == nil {
		return 0
	}

	n := rangeSumBST(root.Left, low, high) + rangeSumBST(root.Right, low, high)
	if low <= root.Val && root.Val <= high {
		n += root.Val
	}
	return n
}
