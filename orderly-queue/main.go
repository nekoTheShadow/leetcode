package main

import (
	"fmt"
	"sort"
	"strings"
)

func orderlyQueue(s string, k int) string {
	if k > 1 {
		a := []rune(s)
		sort.Slice(a, func(i, j int) bool { return a[i] < a[j] })
		var ans strings.Builder
		for _, ch := range a {
			ans.WriteRune(ch)
		}
		return ans.String()
	} else {
		min := s
		for i := 0; i < len(s); i++ {
			s = s[1:] + s[0:1]
			if s < min {
				min = s
			}

		}
		return min
	}

}

func main() {
	fmt.Println(orderlyQueue("cba", 1))
	fmt.Println(orderlyQueue("baaca", 3))
}
