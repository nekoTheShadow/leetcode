package main

import (
	"fmt"
	"strconv"
	"strings"
)

func countAndSay(n int) string {
	s := []int{1}
	for i := 1; i < n; i++ {
		s = say(s)
	}

	var sb strings.Builder
	for _, v := range s {
		sb.WriteString(strconv.Itoa(v))
	}

	return sb.String()
}

func say(s []int) []int {
	last := s[0]
	count := 1
	t := []int{}
	for i := 1; i < len(s); i++ {
		if last == s[i] {
			count++
		} else {
			t = append(t, count, last)
			last = s[i]
			count = 1
		}
	}

	t = append(t, count, last)
	return t
}

func main() {
	fmt.Println(countAndSay(1))
	fmt.Println(countAndSay(4))
}
