package main

import "sort"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func widthOfBinaryTree(root *TreeNode) int {
	type Tuple struct {
		width int
		depth int
		node  *TreeNode
	}

	q := []*Tuple{{width: 1, depth: 1, node: root}}
	ptr := 0

	d := map[int][]int{}
	for ptr < len(q) {
		cur := q[ptr]
		ptr++

		if _, ok := d[cur.depth]; !ok {
			d[cur.depth] = []int{}
		}
		d[cur.depth] = append(d[cur.depth], cur.width)

		if cur.node.Left != nil {
			q = append(q, &Tuple{width: cur.width * 2, depth: cur.depth + 1, node: cur.node.Left})
		}
		if cur.node.Right != nil {
			q = append(q, &Tuple{width: cur.width*2 + 1, depth: cur.depth + 1, node: cur.node.Right})
		}
	}

	ans := 0
	for _, depths := range d {
		sort.Ints(depths)
		v := depths[len(depths)-1] - depths[0] + 1
		if ans < v {
			ans = v
		}
	}
	return ans
}
