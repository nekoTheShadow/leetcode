package main

import "fmt"

func main() {
	fmt.Println(hasAllCodes("00110110", 2))
	fmt.Println(hasAllCodes("0110", 1))
	fmt.Println(hasAllCodes("0110", 2))
}

func hasAllCodes(s string, k int) bool {
	d := map[string]bool{}
	for i := 0; i < len(s)-k+1; i++ {
		d[s[i:i+k]] = true
	}
	return len(d) == (1 << k)
}
