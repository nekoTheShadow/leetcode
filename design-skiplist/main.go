package main

// https://www.hongo.wide.ad.jp/~jo2lxq/dm/lecture/11.pdf

import (
	"fmt"
	"math"
	"math/rand"
	"time"
)

type Skiplist struct {
	root   *Node
	level  int
	random *rand.Rand
}

type Node struct {
	value int
	next  *Node
	down  *Node
}

func Constructor() Skiplist {
	skiplist := Skiplist{
		level:  4,
		random: rand.New(rand.NewSource(time.Now().UnixNano())),
	}

	heads := []*Node{}
	tails := []*Node{}
	for i := 0; i < skiplist.level; i++ {
		heads = append(heads, &Node{value: math.MinInt64})
		tails = append(tails, &Node{value: math.MaxInt64})
		heads[i].next = tails[i]
	}

	for i := 0; i < skiplist.level-1; i++ {
		heads[i].down = heads[i+1]
		tails[i].down = tails[i+1]
	}

	skiplist.root = heads[0]
	return skiplist
}

func (this *Skiplist) Search(target int) bool {
	node := this.root
	for node != nil {
		if node.next.value == target {
			return true
		} else {
			if node.value < target && target < node.next.value {
				node = node.down
			} else {
				node = node.next
			}
		}
	}
	return false
}

func (this *Skiplist) Add(num int) {
	depth := this.random.Intn(this.level)
	node := this.root
	for i := 0; i < depth; i++ {
		node = node.down
	}

	nodes := []*Node{}
	for node != nil {
		if node.value <= num && num <= node.next.value {
			node.next = &Node{value: num, next: node.next}
			nodes = append(nodes, node.next)
			node = node.down
		} else {
			node = node.next
		}
	}

	for i := 0; i < len(nodes)-1; i++ {
		nodes[i].down = nodes[i+1]
	}
}

func (this *Skiplist) Erase(num int) bool {
	node := this.root
	erased := false
	for node != nil {
		if node.next.value == num {
			node.next = node.next.next
			erased = true
			node = node.down // If there exists multiple num values, removing any one of them is fine.
		} else {
			if node.value < num && num < node.next.value {
				node = node.down
			} else {
				node = node.next
			}
		}
	}
	return erased
}

func (this *Skiplist) Print() {
	start := this.root
	for i := 0; i < this.level; i++ {
		node := start
		for node != nil {
			fmt.Printf("%v -> ", node.value)
			node = node.next
		}
		fmt.Println("NIL")
		start = start.down
	}
}
