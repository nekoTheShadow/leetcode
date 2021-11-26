package main

import (
	"strings"
)

func longestCommonPrefix(strs []string) string {
	ans := ""
	for i := 0; i <= len(strs[0]); i++ {
		substr := strs[0][0:i]
		all := true
		for _, str := range strs {
			if !strings.HasPrefix(str, substr) {
				all = false
				break
			}
		}

		if all {
			ans = substr
		} else {
			break
		}
	}
	return ans
}
