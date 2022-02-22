package main

import "fmt"

func smallestNumber(num int64) int64 {
	negative := num < 0
	if negative {
		num *= -1
	}

	count := make([]int, 10)
	for num > 0 {
		count[num%10]++
		num /= 10
	}

	if negative {
		ans := 0
		for i := 9; i >= 0; i-- {
			for j := 0; j < count[i]; j++ {
				ans = ans*10 + i
			}
		}
		return int64(-ans)
	} else {
		min := 0
		for i := 1; i <= 9; i++ {
			if count[i] > 0 {
				min = i
				break
			}
		}

		ans := min
		count[min]--
		for i := 0; i <= 9; i++ {
			for j := 0; j < count[i]; j++ {
				ans = ans*10 + i
			}
		}
		return int64(ans)
	}
}

func main() {
	fmt.Println(smallestNumber(310))
	fmt.Println(smallestNumber(-7605))
	fmt.Println(smallestNumber(5059))
}
