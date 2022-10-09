package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func findTarget(root *TreeNode, k int) bool {
	set = map[int]bool{}
	K = k
	return dfs(root)
}

var set map[int]bool
var K int

func dfs(root *TreeNode) bool {
	if root == nil {
		return false
	}

	if _, ok := set[K-root.Val]; ok {
		return true
	}

	set[root.Val] = true
	return dfs(root.Left) || dfs(root.Right)
}
