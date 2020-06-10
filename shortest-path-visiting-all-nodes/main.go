package main

import "math"

func shortestPathLength(graph [][]int) int {
	n := len(graph)
	q := NewDeque()
	score := make([][]int, n)

	for i := 0; i < len(score); i++ {
		score[i] = make([]int, 1<<n)
	}
	for i := 0; i < n; i++ {
		for j := 0; j < 1<<n; j++ {
			score[i][j] = INFINITY
		}
	}

	for i := 0; i < n; i++ {
		t := Tuple{Cur: i, Bit: 1 << i}
		q.AppendLast(t)
		score[t.Cur][t.Bit] = 0
	}

	ans := INFINITY
	for !q.IsEmpty() {
		t := q.PopFirst().(Tuple)
		if t.Bit == (1<<n)-1 {
			ans = Min(ans, score[t.Cur][t.Bit])
			continue
		}

		for _, nxt := range graph[t.Cur] {
			s := Tuple{Cur: nxt, Bit: t.Bit | (1 << nxt)}
			if score[t.Cur][t.Bit]+1 < score[s.Cur][s.Bit] {
				q.AppendLast(s)
				score[s.Cur][s.Bit] = score[t.Cur][t.Bit] + 1
			}
		}
	}

	return ans
}

const INFINITY = math.MaxInt64/2 - 1

type Tuple struct {
	Cur int
	Bit int
}

// =================================================

type Deque struct {
	head []interface{}
	tail []interface{}
}

func NewDeque() *Deque {
	return &Deque{
		head: []interface{}{},
		tail: []interface{}{},
	}
}

func (d *Deque) AppendLast(v interface{}) {
	d.tail = append(d.tail, v)
}

func (d *Deque) AppendFirst(v interface{}) {
	d.head = append(d.head, v)
}

func (d *Deque) PopLast() interface{} {
	if len(d.tail) == 0 {
		v := d.head[0]
		d.head = d.head[1:]
		return v
	} else {
		v := d.tail[len(d.tail)-1]
		d.tail = d.tail[:len(d.tail)-1]
		return v
	}
}

func (d *Deque) PopFirst() interface{} {
	if len(d.head) == 0 {
		v := d.tail[0]
		d.tail = d.tail[1:]
		return v
	} else {
		v := d.head[len(d.head)-1]
		d.head = d.head[:len(d.head)-1]
		return v
	}
}

func (d *Deque) IsEmpty() bool {
	return len(d.head) == 0 && len(d.tail) == 0
}

func (d *Deque) PeekFirst() interface{} {
	if len(d.head) == 0 {
		return d.tail[0]
	} else {
		return d.head[len(d.head)-1]
	}
}

func (d *Deque) PeekLast() interface{} {
	if len(d.tail) == 0 {
		return d.head[0]
	} else {
		return d.tail[len(d.tail)-1]
	}
}

func Min(a int, b ...int) int {
	for _, v := range b {
		if v < a {
			a = v
		}
	}
	return a
}
