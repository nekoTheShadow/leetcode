package main

import (
	"fmt"
)

func minWindow(s string, t string) string {
	q := map[string]int{}
	for i := 0; i < len(t); i++ {
		q[t[i:i+1]]++
	}

	right := 0
	p := map[string]int{}
	ans := ""
	for left := 0; left < len(s); left++ {
		for right < len(s) && check(p, q, s[right:right+1]) {
			p[s[right:right+1]]++
			right++
		}

		if right < len(s) {
			if ans == "" {
				ans = s[left : right+1]
			} else {
				if len(s[left:right+1]) < len(ans) {
					ans = s[left : right+1]
				}
			}
		}

		if right == left {
			right++
		} else {
			p[s[left:left+1]]--
		}
	}

	return ans
}

func check(p map[string]int, q map[string]int, ch string) bool {
	for k := range q {
		if k == ch {
			if p[k]+1 < q[k] {
				return true
			}
		} else {
			if p[k] < q[k] {
				return true
			}
		}
	}
	return false
}

func main() {
	fmt.Println(minWindow("ADOBECODEBANC", "ABC"))
	fmt.Println(minWindow("a", "a"))
	fmt.Println(minWindow("a", "aa"))
}
