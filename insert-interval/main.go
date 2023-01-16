package main

import "sort"

func insert(intervals [][]int, newInterval []int) [][]int {
	intervals = append(intervals, newInterval)
	sort.Slice(intervals, func(i, j int) bool { return intervals[i][0] < intervals[j][0] })

	ret := [][]int{}
	for _, interval := range intervals {
		if len(ret) > 0 && ret[len(ret)-1][1] >= interval[0] {
			ret[len(ret)-1][1] = Max(ret[len(ret)-1][1], interval[1])
		} else {
			ret = append(ret, interval)
		}
	}
	return ret
}

func Max(a, b int) int {
	if a < b {
		return b
	} else {
		return a
	}
}
