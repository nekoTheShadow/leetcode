package main

import (
	"fmt"
	"strings"
)

// func simplifyPath(path string) string {
// 	return filepath.Clean(path)
// }

func simplifyPath(path string) string {
	stack := []string{}
	for _, token := range strings.Split(path, "/") {
		if token == "." || token == "" {
			continue
		}

		if token == ".." {
			if len(stack) > 0 {
				stack = stack[0 : len(stack)-1]
			}
		} else {
			stack = append(stack, token)
		}
	}

	return "/" + strings.Join(stack, "/")
}

func main() {
	fmt.Println(simplifyPath("/home/"))
	fmt.Println(simplifyPath("/../"))
	fmt.Println(simplifyPath("/home//foo/"))
}
