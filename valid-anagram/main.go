package main

import (
	"sort"
	"strings"
)

func isAnagram(s string, t string) bool {
	a := strings.Split(s, "")
	b := strings.Split(t, "")

	sort.Strings(a)
	sort.Strings(b)

	p := strings.Join(a, "")
	q := strings.Join(b, "")
	return p == q
}
