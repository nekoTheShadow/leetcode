package main

import "fmt"

var NUMS []int
var NUMSSLOTS int
var MEMO map[int]int

func maximumANDSum(nums []int, numSlots int) int {
	NUMS = nums
	NUMSSLOTS = numSlots
	MEMO = map[int]int{}
	return f(0, 0)
}

func f(x int, bit int) int {
	if x == len(NUMS) {
		return 0
	}

	if _, ok := MEMO[bit]; ok {
		return MEMO[bit]
	}

	ans := 0
	for i := 1; i <= NUMSSLOTS; i++ {
		if (bit & (1 << (i*2 - 2))) == 0 {
			v := NUMS[x]&i + f(x+1, bit|(1<<(i*2-2)))
			if ans < v {
				ans = v
			}
		} else if (bit & (1 << (i*2 - 1))) == 0 {
			v := NUMS[x]&i + f(x+1, bit|(1<<(i*2-1)))
			if ans < v {
				ans = v
			}
		}
	}

	MEMO[bit] = ans
	return ans
}

func main() {
	fmt.Println(maximumANDSum([]int{1, 2, 3, 4, 5, 6}, 3))
	fmt.Println(maximumANDSum([]int{1, 3, 10, 4, 7, 1}, 9))
}
