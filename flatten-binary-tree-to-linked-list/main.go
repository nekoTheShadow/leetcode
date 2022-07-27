package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func flatten(root *TreeNode) {
	if root == nil {
		return
	}

	if root.Left != nil {
		leaf := findLeaf(root.Left)
		leaf.Right = root.Right
		root.Right = root.Left
		root.Left = nil
	}

	flatten(root.Right)
}

func findLeaf(cur *TreeNode) *TreeNode {
	if cur.Right != nil {
		return findLeaf(cur.Right)
	}
	if cur.Left != nil {
		return findLeaf(cur.Left)
	}
	return cur
}

func main() {
	root := makeTree([]int{1, 2, 5, 3, 4, -1, 6})
	prettyPrint(root)
	flatten(root)
	prettyPrint(root)
}

func makeTree(vals []int) *TreeNode {
	nodes := []*TreeNode{}
	for _, val := range vals {
		if val == -1 {
			nodes = append(nodes, nil)
		} else {
			nodes = append(nodes, &TreeNode{Val: val})
		}
	}

	n := len(nodes)
	for i := 0; i < n; i++ {
		if nodes[i] == nil {
			continue
		}

		if 2*i+1 < n {
			nodes[i].Left = nodes[2*i+1]
		}
		if 2*i+2 < n {
			nodes[i].Right = nodes[2*i+2]
		}
	}
	return nodes[0]
}

func prettyPrint(root *TreeNode) {
	nodes := []*TreeNode{root}

	for {
		all := true
		for _, node := range nodes {
			if node != nil {
				all = false
				break
			}
		}
		if all {
			break
		}

		vals := []int{}
		for _, node := range nodes {
			if node == nil {
				vals = append(vals, -1)
			} else {
				vals = append(vals, node.Val)
			}
		}
		fmt.Println(vals)

		nxts := []*TreeNode{}
		for _, node := range nodes {
			if node == nil {
				nxts = append(nxts, nil)
				nxts = append(nxts, nil)
			} else {
				nxts = append(nxts, node.Left)
				nxts = append(nxts, node.Right)
			}
		}
		nodes = nxts
	}
}
