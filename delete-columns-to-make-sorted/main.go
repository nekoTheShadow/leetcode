package main

import "fmt"

func minDeletionSize(strs []string) int {
	ans := 0

	for j := 0; j < len(strs[0]); j++ {
		for i := 0; i < len(strs)-1; i++ {
			if strs[i][j] > strs[i+1][j] {
				ans++
				break
			}
		}
	}

	return ans
}

func main() {
	fmt.Println(minDeletionSize([]string{"cba", "daf", "ghi"}))
	fmt.Println(minDeletionSize([]string{"a", "b"}))
	fmt.Println(minDeletionSize([]string{"zyx", "wvu", "tsr"}))
}
