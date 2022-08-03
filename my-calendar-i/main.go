package main

type MyCalendar struct {
	rngs [][]int
}

func Constructor() MyCalendar {
	return MyCalendar{rngs: [][]int{}}
}

func (this *MyCalendar) Book(start int, end int) bool {
	for _, rng := range this.rngs {
		if start <= rng[1] && rng[0] <= end {
			return false
		}
	}
	this.rngs = append(this.rngs, []int{start, end})
	return true
}
