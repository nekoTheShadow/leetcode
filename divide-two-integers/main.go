package main

import "fmt"

func divide(dividend int, divisor int) int {
	positive := (dividend > 0) == (divisor > 0)

	if dividend < 0 {
		dividend = -dividend
	}
	if divisor < 0 {
		divisor = -divisor
	}

	res := 0
	for dividend >= divisor {
		temp := divisor
		i := 1
		for dividend >= temp {
			dividend -= temp
			res += i
			i <<= 1
			temp <<= 1
		}
	}

	if !positive {
		res = -res
	}

	min := -(1 << 31)
	max := 1<<31 - 1
	if res < min {
		return min
	} else if max < res {
		return max
	} else {
		return res
	}
}

func main() {
	fmt.Println(divide(10, 3))
	fmt.Println(divide(7, -3))
}
