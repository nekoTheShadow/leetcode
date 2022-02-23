package main

type Node struct {
	Val       int
	Neighbors []*Node
}

func cloneGraph(node *Node) *Node {
	if node == nil {
		return nil
	}
	return solve(node, map[int]*Node{})
}

func solve(node *Node, visited map[int]*Node) *Node {
	if _, ok := visited[node.Val]; ok {
		return visited[node.Val]
	}
	visited[node.Val] = &Node{Val: node.Val, Neighbors: []*Node{}}
	for _, neighbor := range node.Neighbors {
		visited[node.Val].Neighbors = append(visited[node.Val].Neighbors, solve(neighbor, visited))
	}
	return visited[node.Val]
}
