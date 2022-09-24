package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func pathSum(root *TreeNode, targetSum int) [][]int {
	path = []int{}
	sum = 0
	ans = [][]int{}
	target = targetSum
	dfs(root)
	return ans
}

var path []int
var sum int
var ans [][]int
var target int

func dfs(root *TreeNode) {
	if root == nil {
		return
	}

	path = append(path, root.Val)
	sum += root.Val

	if root.Left == nil && root.Right == nil {
		if target == sum {
			ans = append(ans, append([]int{}, path...))
		}

	} else {
		dfs(root.Left)
		dfs(root.Right)
	}

	path = path[0 : len(path)-1]
	sum -= root.Val
}
