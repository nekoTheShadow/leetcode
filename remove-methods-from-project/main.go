package main

import (
	"github.com/emirpasic/gods/v2/stacks/arraystack"
)

func remainingMethods(n int, k int, invocations [][]int) []int {
	graph := make([][]int, n)
	for i := range n {
		graph[i] = []int{}
	}
	for _, invocation := range invocations {
		a := invocation[0]
		b := invocation[1]
		graph[a] = append(graph[a], b)
	}

	stack := arraystack.New[int]()
	suspicious := map[int]bool{}
	stack.Push(k)
	suspicious[k] = true
	for !stack.Empty() {
		cur, _ := stack.Pop()
		for _, nxt := range graph[cur] {
			if !Contains(suspicious, nxt) {
				suspicious[nxt] = true
				stack.Push(nxt)
			}
		}
	}

	visited := map[int]bool{}
	for start := range n {
		if Contains(suspicious, start) || Contains(visited, start) {
			continue
		}

		stack := arraystack.New[int]()
		stack.Push(start)
		for !stack.Empty() {
			cur, _ := stack.Pop()
			for _, nxt := range graph[cur] {
				if Contains(suspicious, nxt) {
					ans := []int{}
					for i := range n {
						ans = append(ans, i)
					}
					return ans
				}
				if !Contains(visited, nxt) {
					visited[nxt] = true
					stack.Push(nxt)
				}
			}
		}
	}

	ans := []int{}
	for v := range n {
		if _, ok := suspicious[v]; !ok {
			ans = append(ans, v)
		}
	}
	return ans
}

func Contains(set map[int]bool, v int) bool {
	_, ok := set[v]
	return ok
}
