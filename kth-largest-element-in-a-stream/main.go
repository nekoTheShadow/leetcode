package main

import (
	"fmt"
	"sort"
)

type KthLargest struct {
	a []int
	k int
}

func Constructor(k int, nums []int) KthLargest {
	sort.Ints(nums)
	return KthLargest{a: nums, k: k}
}

func (this *KthLargest) Add(val int) int {
	index := sort.SearchInts(this.a, val)
	if len(this.a) == index {
		this.a = append(this.a, val)
	} else {
		this.a = append(this.a[:index+1], this.a[index:]...)
		this.a[index] = val
	}
	return this.a[len(this.a)-this.k]
}

func main() {
	kl := Constructor(3, []int{4, 5, 8, 2})
	fmt.Println(kl.Add(3))
	fmt.Println(kl.Add(5))
	fmt.Println(kl.Add(10))
	fmt.Println(kl.Add(9))
	fmt.Println(kl.Add(4))
}
