package main

import "fmt"

func subarraysDivByK(nums []int, k int) int {
	n := len(nums)
	s := make([]int, n+1)
	for i := 0; i < n; i++ {
		s[i+1] = s[i] + nums[i]
	}
	for i := 0; i <= n; i++ {
		s[i] %= k
		if s[i] < 0 {
			s[i] += k
		}
	}

	d := map[int]int{}
	ans := 0
	for i := 0; i <= n; i++ {
		if _, ok := d[s[i]]; ok {
			ans += d[s[i]]
		}

		if _, ok := d[s[i]]; !ok {
			d[s[i]] = 0
		}
		d[s[i]]++
	}
	return ans
}

func main() {
	fmt.Println(subarraysDivByK([]int{4, 5, 0, -2, -3, 1}, 5))
	fmt.Println(subarraysDivByK([]int{5}, 9))
	fmt.Println(subarraysDivByK([]int{-1, -9, -4, 0}, 9))
	fmt.Println(subarraysDivByK([]int{-1, 2, 9}, 2))
}
