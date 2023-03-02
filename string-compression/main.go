package main

import (
	"fmt"
	"strconv"
	"strings"
)

func compress(chars []byte) int {
	i := 0
	n := len(chars)
	p := 0
	for i < n {
		j := i + 1
		for j < n && chars[i] == chars[j] {
			j++
		}
		chars[p] = chars[i]
		p++

		x := j - i
		if x > 1 {
			for _, v := range strconv.Itoa(j - i) {
				chars[p] = byte(v)
				p++
			}
		}

		i = j

	}

	return p
}

func main() {
	run([]byte{'a', 'a', 'b', 'b', 'c', 'c', 'c'})
	run([]byte{'a'})
	run([]byte{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'})
}

func run(chars []byte) {
	x := compress(chars)

	var sb strings.Builder
	for i := 0; i < x; i++ {
		sb.WriteByte(chars[i])
	}
	fmt.Println(sb.String())
}
