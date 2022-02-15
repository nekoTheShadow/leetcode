package main

import "fmt"

func findLonely(nums []int) []int {
	c := map[int]int{}
	for _, k := range nums {
		if v, ok := c[k]; ok {
			c[k] = v + 1
		} else {
			c[k] = 1
		}
	}

	ans := []int{}
	for _, k := range nums {
		_, ok1 := c[k-1]
		_, ok2 := c[k+1]
		if c[k] == 1 && !ok1 && !ok2 {
			ans = append(ans, k)
		}
	}
	return ans
}

func main() {
	fmt.Println(findLonely([]int{10, 6, 5, 8})) //=> 10,8
	fmt.Println(findLonely([]int{1, 3, 5, 3}))  //=> 1,5
}
