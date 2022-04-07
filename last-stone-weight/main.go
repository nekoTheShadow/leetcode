package main

import (
	"container/heap"
	"fmt"
)

type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] > h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func Abs(x int) int {
	if x > 0 {
		return x
	} else {
		return -x
	}
}

func lastStoneWeight(stones []int) int {
	h := &IntHeap{}
	for _, stone := range stones {
		heap.Push(h, stone)
	}

	for h.Len() > 1 {
		stone1 := heap.Pop(h).(int)
		stone2 := heap.Pop(h).(int)
		if stone1 != stone2 {
			heap.Push(h, Abs(stone1-stone2))
		}
	}

	if h.Len() == 0 {
		return 0
	} else {
		return h.Pop().(int)
	}
}

func main() {
	fmt.Println(lastStoneWeight([]int{2, 7, 4, 1, 8, 1}))
	fmt.Println(lastStoneWeight([]int{1}))
}
