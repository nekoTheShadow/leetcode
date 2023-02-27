package main

type Node struct {
	Val         bool
	IsLeaf      bool
	TopLeft     *Node
	TopRight    *Node
	BottomLeft  *Node
	BottomRight *Node
}

func construct(grid [][]int) *Node {
	return build(grid, 0, 0, len(grid))
}

func build(grid [][]int, x int, y int, n int) *Node {
	c0 := 0
	c1 := 0
	for i := x; i < x+n; i++ {
		for j := y; j < y+n; j++ {
			if grid[i][j] == 0 {
				c0++
			} else {
				c1++
			}
		}
	}

	if c0 == 0 {
		return &Node{Val: true, IsLeaf: true}
	} else if c1 == 0 {
		return &Node{Val: false, IsLeaf: true}
	} else {
		return &Node{
			IsLeaf:      false,
			TopLeft:     build(grid, x, y, n/2),
			TopRight:    build(grid, x, y+n/2, n/2),
			BottomLeft:  build(grid, x+n/2, y, n/2),
			BottomRight: build(grid, x+n/2, y+n/2, n/2),
		}
	}
}
