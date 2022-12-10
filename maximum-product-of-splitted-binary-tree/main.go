package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var total uint64
var max uint64

func maxProduct(root *TreeNode) int {
	total = sum(root)
	max = uint64(0)
	sum(root)
	return int(max % 1000000007)
}

func sum(root *TreeNode) uint64 {
	if root == nil {
		return 0
	}

	v := sum(root.Left) + sum(root.Right) + uint64(root.Val)
	if max < (v * (total - v)) {
		max = v * (total - v)
	}

	return v
}
