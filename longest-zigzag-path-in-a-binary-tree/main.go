package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func longestZigZag(root *TreeNode) int {
	ans := 0
	dfs(root, -0, 0, &ans)
	return ans
}

func dfs(root *TreeNode, l int, r int, ans *int) {
	if root == nil {
		return
	}

	*ans = Max(*ans, l)
	*ans = Max(*ans, r)
	dfs(root.Left, 0, l+1, ans)
	dfs(root.Right, r+1, 0, ans)
}

func Max(a, b int) int {
	if a < b {
		return b
	} else {
		return a
	}
}
