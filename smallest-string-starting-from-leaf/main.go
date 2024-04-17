package main

import "fmt"

func smallestFromLeaf(root *TreeNode) string {
	word := ""
	ret := ""
	dfs(root, &word, &ret)
	return ret
}

func dfs(node *TreeNode, word *string, ret *string) {
	if node == nil {
		return
	}

	*word = string(rune('a'+node.Val)) + *word

	if node.Left == nil && node.Right == nil {
		if *ret == "" || *word < *ret {
			*ret = *word
		}
	}

	dfs(node.Left, word, ret)
	dfs(node.Right, word, ret)

	*word = (*word)[1:]
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
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

func main() {
	fmt.Println(smallestFromLeaf(buildTree([]int{0, 1, 2, 3, 4, 3, 4})))
	fmt.Println(smallestFromLeaf(buildTree([]int{25, 1, 3, 1, 3, 0, 2})))
	fmt.Println(smallestFromLeaf(buildTree([]int{2, 2, 1, -1, 1, 0, -1, -1, -1, 0})))
}
