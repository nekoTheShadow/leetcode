package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func pruneTree(root *TreeNode) *TreeNode {
	if has1(root) {
		return root
	} else {
		return nil
	}
}

func has1(cur *TreeNode) bool {
	if cur == nil {
		return false
	}
	leftHas1 := has1(cur.Left)
	rightHas1 := has1(cur.Right)
	if !leftHas1 {
		cur.Left = nil
	}
	if !rightHas1 {
		cur.Right = nil
	}
	return cur.Val == 1 || leftHas1 || rightHas1
}
