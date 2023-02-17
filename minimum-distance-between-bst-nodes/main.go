package main

import "math"

func minDiffInBST(root *TreeNode) int {
	pre = nil
	min = math.MaxInt
	dfs(root)
	return min
}

var pre *TreeNode
var min int

func dfs(root *TreeNode) {
	if root == nil {
		return
	}

	dfs(root.Left)

	if pre != nil {
		v := pre.Val - root.Val
		if v < 0 {
			v *= -1
		}
		if v < min {
			min = v
		}
	}
	pre = root

	dfs(root.Right)
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
