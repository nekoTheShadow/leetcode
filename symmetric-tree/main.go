package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSymmetric(root *TreeNode) bool {
	nodes := []*TreeNode{root}
	for {
		finish := true
		for _, node := range nodes {
			if node != nil {
				finish = false
				break
			}
		}
		if finish {
			break
		}

		n := len(nodes)
		for i := 0; i < n/2; i++ {
			node1 := nodes[i]
			node2 := nodes[n-i-1]
			if !((node1 == nil && node2 == nil) || (node1 != nil && node2 != nil && node1.Val == node2.Val)) {
				return false
			}
		}

		nextNodes := []*TreeNode{}
		for i := 0; i < n; i++ {
			if nodes[i] == nil {
				nextNodes = append(nextNodes, nil)
				nextNodes = append(nextNodes, nil)
			} else {
				nextNodes = append(nextNodes, nodes[i].Left)
				nextNodes = append(nextNodes, nodes[i].Right)
			}
		}
		nodes = nextNodes
	}

	return true
}
