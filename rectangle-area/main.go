package main

func computeArea(ax1 int, ay1 int, ax2 int, ay2 int, bx1 int, by1 int, bx2 int, by2 int) int {
	left := max(ax1, bx1)
	right := max(min(ax2, bx2), left)
	bottom := max(ay1, by1)
	top := max(min(ay2, by2), bottom)
	return (ax2-ax1)*(ay2-ay1) - (right-left)*(top-bottom) + (bx2-bx1)*(by2-by1)
}

func min(x, y int) int {
	if x < y {
		return x
	} else {
		return y
	}
}

func max(x, y int) int {
	if x < y {
		return y
	} else {
		return x
	}
}
