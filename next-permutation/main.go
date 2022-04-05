package main

import "fmt"

func nextPermutation(nums []int) {
	n := len(nums)

	// Find the largest index k such that a[k] < a[k + 1].
	// If no such index exists, the permutation is the last permutation.
	k := n - 2
	for k >= 0 {
		if nums[k] < nums[k+1] {
			break
		}
		k--
	}

	if k < 0 {
		reverse(nums, 0, n-1)
	} else {
		// Find the largest index l greater than k such that a[k] < a[l].
		l := n - 1
		for k < l {
			if nums[k] < nums[l] {
				break
			}
			l--
		}

		// Swap the value of a[k] with that of a[l].
		nums[k], nums[l] = nums[l], nums[k]

		// Reverse the sequence from a[k + 1] up to and including the final element a[n].
		reverse(nums, k+1, n-1)
	}
}

func reverse(nums []int, i int, j int) {
	for i < j {
		nums[i], nums[j] = nums[j], nums[i]
		i++
		j--
	}
}

func main() {
	solve([]int{1, 2, 3})
	solve([]int{3, 2, 1})
	solve([]int{1, 1, 5})
}

func solve(nums []int) {
	nextPermutation(nums)
	fmt.Println(nums)
}
