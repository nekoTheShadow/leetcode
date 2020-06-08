package main

var H int
var W int
var RR *Ruiseki2Result
var MEMO map[Key]int

type Key struct {
	x int
	y int
	k int
}

func ways(pizza []string, k int) int {
	H = len(pizza)
	W = len(pizza[0])
	MEMO = map[Key]int{}

	rb := NewRuiseki2Builder(H, W)
	for i := 0; i < H; i++ {
		for j := 0; j < W; j++ {
			if pizza[i][j] == 'A' {
				rb.Set(i, j, 1)
			}
		}
	}
	RR = rb.Build()
	return f(0, 0, k)
}

func f(x int, y int, k int) int {
	if k == 1 {
		if RR.Get(x, y, H, W) > 0 {
			return 1
		} else {
			return 0
		}
	}

	key := Key{x: x, y: y, k: k}
	if v, ok := MEMO[key]; ok {
		return v
	}

	ans := 0
	for i := x + 1; i < H; i++ {
		if RR.Get(x, y, i, W) > 0 {
			ans += f(i, y, k-1)
			ans %= 1e9 + 7
		}
	}

	for j := y + 1; j < W; j++ {
		if RR.Get(x, y, H, j) > 0 {
			ans += f(x, j, k-1)
			ans %= 1e9 + 7
		}
	}

	MEMO[key] = ans
	return ans
}

// == MY LIBRARY ==

type Ruiseki2Builder struct {
	a [][]int
	h int
	w int
}

type Ruiseki2Result struct {
	s [][]int
}

func NewRuiseki2Builder(h, w int) *Ruiseki2Builder {
	a := createMatrix(h, w)
	return &Ruiseki2Builder{a: a, h: h, w: w}
}

func (r *Ruiseki2Builder) Set(x, y, v int) {
	r.a[x][y] = v
}

func (r *Ruiseki2Builder) Build() *Ruiseki2Result {
	s := createMatrix(r.h+1, r.w+1)
	for i := 0; i < r.h; i++ {
		for j := 0; j < r.w; j++ {
			s[i+1][j+1] = s[i][j+1] + s[i+1][j] - s[i][j] + r.a[i][j]
		}
	}
	return &Ruiseki2Result{s: s}
}

func (r *Ruiseki2Result) Get(x1, y1, x2, y2 int) int {
	return r.s[x2][y2] - r.s[x1][y2] - r.s[x2][y1] + r.s[x1][y1]
}

func createMatrix(h, w int) [][]int {
	a := make([][]int, h)
	for i := 0; i < h; i++ {
		a[i] = make([]int, w)
	}
	return a
}
