package main

import "fmt"

func maxOperations(nums []int, k int) int {
	d := map[int]int{}
	for _, num := range nums {
		if _, ok := d[num]; !ok {
			d[num] = 0
		}
		d[num]++
	}

	ans := 0
	for num1 := range d {
		num2 := k - num1
		if _, ok := d[num2]; !ok {
			continue
		}

		if num1 == num2 {
			x := d[num1] / 2
			ans += x
			d[num1] -= x * 2
		} else {
			var x int
			if d[num1] <= d[num2] {
				x = d[num1]
			} else {
				x = d[num2]
			}
			ans += x
			d[num1] -= x
			d[num2] -= x
		}
	}

	return ans
}

func main() {
	fmt.Println(maxOperations([]int{1, 2, 3, 4}, 5))
	fmt.Println(maxOperations([]int{3, 1, 3, 4, 3}, 6))
}
