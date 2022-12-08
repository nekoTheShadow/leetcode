package main

import "reflect"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func leafSimilar(root1 *TreeNode, root2 *TreeNode) bool {
	a1 := []int{}
	a2 := []int{}
	dfs(root1, &a1)
	dfs(root2, &a2)
	return reflect.DeepEqual(a1, a2)
}

func dfs(root *TreeNode, a *[]int) {
	if root == nil {
		return
	}

	dfs(root.Left, a)
	if root.Left == nil && root.Right == nil {
		*a = append(*a, root.Val)
	}
	dfs(root.Right, a)
}
