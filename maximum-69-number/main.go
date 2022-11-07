package main

import "fmt"

func maximum69Number(num int) int {
	a := []int{}
	for num > 0 {
		a = append(a, num%10)
		num /= 10
	}

	ret := 0
	first := true
	for i := len(a) - 1; i >= 0; i-- {
		x := a[i]
		if x == 6 && first {
			x = 9
			first = false
		}

		ret = ret*10 + x
	}

	return ret
}

func main() {
	fmt.Println(maximum69Number(9669))
	fmt.Println(maximum69Number(9996))
	fmt.Println(maximum69Number(9999))
}
