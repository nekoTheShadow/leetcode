package main

import "fmt"

func isCompleteTree(root *TreeNode) bool {
	if root == nil {
		return true
	}

	a := []*TreeNode{root}
	for {
		b := []*TreeNode{}
		for _, v := range a {
			if v == nil {
				b = append(b, nil)
				b = append(b, nil)
			} else {
				b = append(b, v.Left)
				b = append(b, v.Right)
			}
		}

		isbottom := true
		for _, v := range b {
			if v != nil {
				isbottom = false
				break
			}
		}

		if isbottom {
			n := len(a) - 1
			for a[n] == nil {
				n--
			}
			for i := 0; i <= n; i++ {
				if a[i] == nil {
					return false
				}
			}
			return true
		} else {
			for _, v := range a {
				if v == nil {
					return false
				}
			}
		}

		a = b
	}
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	fmt.Println(isCompleteTree(createTree([]int{1, 2, 3, 4, 5, 6})))
	fmt.Println(isCompleteTree(createTree([]int{1, 2, 3, 4, 5, -1, 7})))
}

func createTree(vals []int) *TreeNode {
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

		x := i*2 + 1
		y := i*2 + 2
		if x < n {
			nodes[i].Left = nodes[x]
		}
		if y < n {
			nodes[i].Right = nodes[y]
		}
	}

	return nodes[0]
}
