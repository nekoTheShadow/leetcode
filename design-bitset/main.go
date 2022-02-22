package main

import (
	"fmt"
	"strings"
)

type Bitset struct {
	size int
	one  map[int]bool
	zero map[int]bool
}

func Constructor(size int) Bitset {
	zero := map[int]bool{}
	for i := 0; i < size; i++ {
		zero[i] = true
	}
	return Bitset{size: size, one: map[int]bool{}, zero: zero}
}

func (this *Bitset) Fix(idx int) {
	this.one[idx] = true
	delete(this.zero, idx)
}

func (this *Bitset) Unfix(idx int) {
	this.zero[idx] = true
	delete(this.one, idx)
}

func (this *Bitset) Flip() {
	this.one, this.zero = this.zero, this.one
}

func (this *Bitset) All() bool {
	return this.Count() == this.size
}

func (this *Bitset) One() bool {
	return this.Count() > 0
}

func (this *Bitset) Count() int {
	return len(this.one)
}

func (this *Bitset) ToString() string {
	var a strings.Builder
	for i := 0; i < this.size; i++ {
		if _, ok := this.one[i]; ok {
			a.WriteString("1")
		} else {
			a.WriteString("0")
		}
	}

	return a.String()
}

func main() {
	exampleCase()
}

func exampleCase() {
	bitset := Constructor(5)
	bitset.Fix(3)
	bitset.Fix(1)
	bitset.Flip()
	fmt.Println(bitset.All())
	bitset.Unfix(0)
	bitset.Flip()
	fmt.Println(bitset.One())
	bitset.Unfix(0)
	fmt.Println(bitset.Count())
	fmt.Println(bitset.ToString())
}
