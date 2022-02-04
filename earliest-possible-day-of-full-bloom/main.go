package main

import "sort"

type Tuple struct {
	plantTime int
	growTime  int
}

func earliestFullBloom(plantTime []int, growTime []int) int {
	tuples := []*Tuple{}
	for i := 0; i < len(plantTime); i++ {
		tuples = append(tuples, &Tuple{plantTime: plantTime[i], growTime: growTime[i]})
	}

	sort.Slice(tuples, func(i int, j int) bool {
		return tuples[i].growTime < tuples[j].growTime
	})

	ans := 0
	for _, tuple := range tuples {
		if ans < tuple.growTime {
			ans = tuple.growTime + tuple.plantTime
		} else {
			ans = ans + tuple.plantTime
		}
	}
	return ans
}
