package main

import (
	"fmt"
	"strconv"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func bstToGst(root *TreeNode) *TreeNode {
	tot := 0
	dfs(root, &tot)
	return root
}

func dfs(node *TreeNode, tot *int) {
	if node == nil {
		return
	}

	dfs(node.Right, tot)
	*tot += node.Val
	node.Val = *tot
	dfs(node.Left, tot)
}

func main() {
	printTree(toTree([]int{4, 1, 6, 0, 2, 5, 7, -1, -1, -1, 3, -1, -1, -1, 8}))
	printTree(bstToGst(toTree([]int{4, 1, 6, 0, 2, 5, 7, -1, -1, -1, 3, -1, -1, -1, 8})))
}

func toTree(vals []int) *TreeNode {
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

func printTree(root *TreeNode) {
	nodes := []*TreeNode{root}
	for {
		newNodes := []*TreeNode{}
		vals := []string{}
		hasNext := false
		for _, node := range nodes {
			if node == nil {
				vals = append(vals, "_")
				newNodes = append(newNodes, nil)
				newNodes = append(newNodes, nil)
			} else {
				vals = append(vals, strconv.Itoa(node.Val))
				newNodes = append(newNodes, node.Left)
				newNodes = append(newNodes, node.Right)
				hasNext = true
			}
		}

		if hasNext {
			fmt.Println(vals)
			nodes = newNodes
		} else {
			break
		}
	}
}
