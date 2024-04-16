package main

import (
	"fmt"
	"strconv"
)

type Tuple struct {
	node *TreeNode
	d    int
}

func addOneRow(root *TreeNode, val int, depth int) *TreeNode {
	if depth == 1 {
		return &TreeNode{Val: val, Left: root}
	}

	que := []*Tuple{{node: root, d: 1}}

	for len(que) > 0 {
		tpl := que[0]
		que = que[1:]

		if tpl.d == depth-1 {
			tpl.node.Left = &TreeNode{Val: val, Left: tpl.node.Left}
			tpl.node.Right = &TreeNode{Val: val, Right: tpl.node.Right}
		} else {
			if tpl.node.Left != nil {
				que = append(que, &Tuple{node: tpl.node.Left, d: tpl.d + 1})
			}
			if tpl.node.Right != nil {
				que = append(que, &Tuple{node: tpl.node.Right, d: tpl.d + 1})
			}
		}
	}

	return root
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	printNode(addOneRow(buildTree([]int{4, 2, 6, 3, 1, 5}), 1, 2))
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

func printNode(root *TreeNode) {
	que := []*Tuple{{node: root, d: 0}}
	vals := []string{}

	for len(que) > 0 {
		fmt.Println(que[0].node.Val)
		tpl := que[0]
		que = que[1:]

		for len(vals) <= tpl.d {
			vals = append(vals, "nil")
		}
		vals[tpl.d] = strconv.Itoa(tpl.node.Val)

		if tpl.node.Left != nil {
			que = append(que, &Tuple{node: tpl.node.Left, d: tpl.d*2 + 1})
		}
		if tpl.node.Right != nil {
			que = append(que, &Tuple{node: tpl.node.Right, d: tpl.d*2 + 2})
		}
	}

	fmt.Println(vals)
}
