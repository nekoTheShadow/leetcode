package main

import "fmt"

type Node struct {
	count    int
	children map[rune]*Node
}

func NewNode() *Node {
	return &Node{count: 0, children: map[rune]*Node{}}
}

type Trie struct {
	root *Node
}

func NewTrie() *Trie {
	return &Trie{root: NewNode()}
}

func (trie *Trie) Add(word string) {
	node := trie.root
	for _, x := range word {
		if _, ok := node.children[x]; !ok {
			node.children[x] = NewNode()
		}
		node.children[x].count += 1
		node = node.children[x]
	}
}

func (trie *Trie) Count(word string) int {
	node := trie.root
	count := 0
	for _, x := range word {
		if _, ok := node.children[x]; !ok {
			break
		}
		count += node.children[x].count
		node = node.children[x]
	}
	return count
}

func sumPrefixScores(words []string) []int {
	trie := NewTrie()
	for _, word := range words {
		trie.Add(word)
	}

	counts := []int{}
	for _, word := range words {
		counts = append(counts, trie.Count(word))
	}
	return counts
}

func main() {
	fmt.Println(sumPrefixScores([]string{"abc", "ab", "bc", "b"}))
	fmt.Println(sumPrefixScores([]string{"abcd"}))
}
