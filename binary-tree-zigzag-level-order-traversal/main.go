package main

func zigzagLevelOrder(root *TreeNode) [][]int {
	nodes := []*TreeNode{}
	if root != nil {
		nodes = append(nodes, root)
	}
	right := true
	matrix := [][]int{}

	for len(nodes) > 0 {
		row := []int{}
		if right {
			for i := 0; i < len(nodes); i++ {
				row = append(row, nodes[i].Val)
			}
		} else {
			for i := len(nodes) - 1; i >= 0; i-- {
				row = append(row, nodes[i].Val)
			}
		}
		matrix = append(matrix, row)
		right = !right

		nextNodes := []*TreeNode{}
		for _, node := range nodes {
			if node.Left != nil {
				nextNodes = append(nextNodes, node.Left)
			}
			if node.Right != nil {
				nextNodes = append(nextNodes, node.Right)
			}
		}
		nodes = nextNodes
	}

	return matrix
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
