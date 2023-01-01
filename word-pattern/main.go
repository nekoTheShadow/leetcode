package main

import "strings"

func wordPattern(pattern string, s string) bool {
	words := strings.Split(s, " ")
	if len(pattern) != len(words) {
		return false
	}

	d := map[rune]string{}
	e := map[string]rune{}
	for i, token := range pattern {
		if _, ok := d[token]; ok && d[token] != words[i] {
			return false
		}
		if _, ok := e[words[i]]; ok && token != e[words[i]] {
			return false
		}

		d[token] = words[i]
		e[words[i]] = token
	}
	return true
}
