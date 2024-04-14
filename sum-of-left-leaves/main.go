package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	fmt.Println(sumOfLeftLeaves(buildTree([]int{3, 9, 20, -1, -1, 15, 7})))
}

func buildTree(vals []int) *TreeNode {
	nodes := []*TreeNode{}
	for _, val := range vals {
		if val == -1 {
			nodes = append(nodes, nil)
		} else {
			nodes = append(nodes, &TreeNode{Val: val})
		}
	}

	n := len(vals)
	for i := 0; i < n; i++ {
		if nodes[i] == nil {
			continue
		}

		if i*2+1 < n {
			nodes[i].Left = nodes[i*2+1]
		}
		if i*2+2 < n {
			nodes[i].Right = nodes[i*2+2]
		}
	}
	return nodes[0]
}

func sumOfLeftLeaves(root *TreeNode) int {
	sum := 0
	dfs(root, "", &sum)
	return sum
}

func dfs(root *TreeNode, prev string, sum *int) {
	if root == nil {
		return
	}

	if root.Left == nil && root.Right == nil && prev == "L" {
		*sum += root.Val
	}
	dfs(root.Left, "L", sum)
	dfs(root.Right, "R", sum)
}
