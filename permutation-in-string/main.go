package main

import "fmt"

func checkInclusion(s1 string, s2 string) bool {
	n1 := len(s1)
	n2 := len(s2)
	if n1 > n2 {
		return false
	}

	d1 := make([]int, 26)
	d2 := make([]int, 26)

	for _, ch := range s1 {
		d1[int(ch)-int('a')]++
	}
	for _, ch := range s2[:n1] {
		d2[int(ch)-int('a')]++
	}

	for i := n1; i <= n2; i++ {
		all := true
		for j := 0; j < 26; j++ {
			if d1[j] != d2[j] {
				all = false
				break
			}
		}
		if all {
			return true
		}

		if i < n2 {
			d2[int(s2[i])-int('a')]++
			d2[int(s2[i-n1])-int('a')]--
		}
	}

	return false
}

func main() {
	fmt.Println(checkInclusion("ab", "eidbaooo"))
	fmt.Println(checkInclusion("ab", "eidboaoo"))
}
