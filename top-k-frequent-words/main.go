package main

import (
	"container/heap"
	"fmt"
)

type Element struct {
	Word  string
	Count int
}

type PriorityQueue []*Element

func (pq PriorityQueue) Len() int      { return len(pq) }
func (pq PriorityQueue) Swap(i, j int) { pq[i], pq[j] = pq[j], pq[i] }
func (pq PriorityQueue) Less(i, j int) bool {
	if pq[i].Count == pq[j].Count {
		return pq[i].Word > pq[j].Word
	} else {
		return pq[i].Count < pq[j].Count
	}
}
func (pq *PriorityQueue) Push(x interface{}) { *pq = append(*pq, x.(*Element)) }
func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	e := old[n-1]
	*pq = old[0 : n-1]
	return e
}

func topKFrequent(words []string, k int) []string {
	counter := map[string]int{}
	for _, word := range words {
		if _, ok := counter[word]; !ok {
			counter[word] = 0
		}
		counter[word]++
	}

	pq := &PriorityQueue{}
	for word, count := range counter {
		heap.Push(pq, &Element{Word: word, Count: count})
		if pq.Len() > k {
			heap.Pop(pq)
		}
	}

	ans := make([]string, k)
	for i := k - 1; i >= 0; i-- {
		ans[i] = heap.Pop(pq).(*Element).Word
	}
	return ans
}

func main() {
	fmt.Println(topKFrequent([]string{"i", "love", "leetcode", "i", "love", "coding"}, 2))
	fmt.Println(topKFrequent([]string{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4))
}
