package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func convertBST(root *TreeNode) *TreeNode {
	sum = 0
	dfs(root)
	return root
}

var sum int

func dfs(cur *TreeNode) {
	if cur == nil {
		return
	}

	dfs(cur.Right)
	cur.Val += sum
	sum = cur.Val
	dfs(cur.Left)
}
