package main

func minimizeArrayValue(nums []int) int {
	sum := 0
	ret := 0
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
		v := (sum + i) / (i + 1)
		if ret < v {
			ret = v
		}
	}
	return ret
}
