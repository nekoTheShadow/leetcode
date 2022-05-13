package main

type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

func connect(root *Node) *Node {
	if root == nil {
		return root
	}

	q := []*Node{root}

	for len(q) > 0 {
		for i := 0; i < len(q)-1; i++ {
			q[i].Next = q[i+1]
		}

		r := []*Node{}
		for _, cur := range q {
			if cur.Left != nil {
				r = append(r, cur.Left)
			}
			if cur.Right != nil {
				r = append(r, cur.Right)
			}
		}
		q = r
	}

	return root
}
