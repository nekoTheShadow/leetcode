package main

import (
	"fmt"
	"math/rand"
	"time"
)

type RandomizedSet struct {
	set  map[int]int
	list []int
	rand *rand.Rand
}

func Constructor() RandomizedSet {
	return RandomizedSet{
		set:  map[int]int{},
		list: []int{},
		rand: rand.New(rand.NewSource(time.Now().UnixNano())),
	}
}

func (this *RandomizedSet) Insert(val int) bool {
	if _, ok := this.set[val]; ok {
		return false
	}
	this.list = append(this.list, val)
	this.set[val] = len(this.list) - 1
	return true
}

func (this *RandomizedSet) Remove(val int) bool {
	if _, ok := this.set[val]; !ok {
		return false
	}

	this.set[this.list[len(this.list)-1]] = this.set[val]
	this.list[this.set[val]], this.list[len(this.list)-1] = this.list[len(this.list)-1], this.list[this.set[val]]

	this.list = this.list[0 : len(this.list)-1]
	delete(this.set, val)
	return true
}

func (this *RandomizedSet) GetRandom() int {
	return this.list[this.rand.Intn(len(this.list))]
}

func main() {
	rs := Constructor()
	fmt.Println(rs.Insert(0))
	fmt.Println(rs.Insert(1))
	fmt.Println(rs.Remove(0))
	fmt.Println(rs.Insert(2))
	fmt.Println(rs.Remove(1))
	fmt.Println(rs.GetRandom())
}
