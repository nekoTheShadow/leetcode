package main

import (
	"fmt"
	"math"
	"strings"
)

func minCost(grid [][]int) int {
	dirs := []struct {
		display int
		x       int
		y       int
	}{
		{display: 1, x: 0, y: 1},  // right
		{display: 2, x: 0, y: -1}, // left
		{display: 3, x: 1, y: 0},  // down
		{display: 4, x: -1, y: 0}, // up
	}
	h := len(grid)
	w := len(grid[0])
	dijk := NewDijkstra2(h, w)
	for i := 0; i < h; i++ {
		for j := 0; j < w; j++ {
			for _, dir := range dirs {
				x := i + dir.x
				y := j + dir.y
				if 0 <= x && x < h && 0 <= y && y < w {
					if grid[i][j] == dir.display {
						dijk.Add(i, j, x, y, 0)
					} else {
						dijk.Add(i, j, x, y, 1)
					}
				}
			}
		}
	}

	score := dijk.Run(0, 0)
	return score[h-1][w-1]
}

// =================================
// ========== MY LIBLARY ===========
// =================================

const INFINITY = math.MaxInt64/2 - 1

type Dijkstra2 struct {
	h     int
	w     int
	nexts map[from][]to
}

type from struct {
	x int
	y int
}

type to struct {
	x    int
	y    int
	cost int
}

func NewDijkstra2(h, w int) *Dijkstra2 {
	return &Dijkstra2{
		h:     h,
		w:     w,
		nexts: make(map[from][]to),
	}
}

func (d *Dijkstra2) Add(x1, y1, x2, y2, cost int) {
	k := from{x: x1, y: y1}
	if _, ok := d.nexts[k]; !ok {
		d.nexts[k] = []to{}
	}
	d.nexts[k] = append(d.nexts[k], to{
		x:    x2,
		y:    y2,
		cost: cost,
	})
}

func (d *Dijkstra2) Run(x, y int) [][]int {
	score := make([][]int, d.h)
	for i := 0; i < d.h; i++ {
		score[i] = make([]int, d.w)
		for j := 0; j < d.w; j++ {
			score[i][j] = INFINITY
		}
	}
	score[x][y] = 0

	q := NewHeapq()
	q.Push(0, from{x: x, y: y})
	for !q.isEmpty() {
		cur := q.Pop().(from)
		if _, ok := d.nexts[cur]; !ok {
			continue
		}
		for _, next := range d.nexts[cur] {
			if score[cur.x][cur.y]+next.cost < score[next.x][next.y] {
				score[next.x][next.y] = score[cur.x][cur.y] + next.cost
				q.Push(score[next.x][next.y], from{x: next.x, y: next.y})
			}
		}
	}

	return score
}

type Heapq struct {
	elements []*element
}

type element struct {
	x int
	v interface{}
}

func NewHeapq() *Heapq {
	return &Heapq{elements: []*element{nil}}
}

func (heapq *Heapq) Push(x int, v interface{}) {
	heapq.elements = append(heapq.elements, &element{x: x, v: v})
	n := len(heapq.elements) - 1
	for n > 1 {
		if heapq.elements[n/2].x < heapq.elements[n].x {
			break
		}
		heapq.elements[n/2], heapq.elements[n] = heapq.elements[n], heapq.elements[n/2]
		n /= 2
	}
}

func (heapq *Heapq) Pop() interface{} {
	head := heapq.elements[1].v
	heapq.elements[1] = heapq.elements[len(heapq.elements)-1]
	heapq.elements = heapq.elements[:len(heapq.elements)-1]

	n := 1
	for n < len(heapq.elements) {
		if n*2 >= len(heapq.elements) {
			break
		}

		var m int
		if n*2+1 >= len(heapq.elements) {
			m = n * 2
		} else {
			if heapq.elements[n*2].x < heapq.elements[n*2+1].x {
				m = n * 2
			} else {
				m = n*2 + 1
			}
		}

		if heapq.elements[n].x < heapq.elements[m].x {
			break
		}
		heapq.elements[n], heapq.elements[m] = heapq.elements[m], heapq.elements[n]
		n = m
	}

	return head
}

func (heapq *Heapq) isEmpty() bool {
	return len(heapq.elements) == 1
}

func (heapq *Heapq) Size() int {
	return len(heapq.elements) - 1
}

func (heapq *Heapq) String() string {
	s := make([]string, len(heapq.elements)-1)
	for i := 1; i < len(heapq.elements); i++ {
		s[i-1] = fmt.Sprintf("%v", heapq.elements[i].v)
	}
	return strings.Join(s, " ")
}
