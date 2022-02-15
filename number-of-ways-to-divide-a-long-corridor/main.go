package main

import "fmt"

func numberOfWays(corridor string) int {
	ans := 1
	seat := 0
	plant := 0
	mod := 1000000007

	for _, ch := range corridor {
		if ch == 'S' {
			if seat == 2 {
				ans = ans * (plant + 1) % mod
				seat = 0
				plant = 0
			}
			seat++
		} else {
			if seat == 2 {
				plant++
			}
		}
	}

	if seat == 2 {
		return ans
	} else {
		return 0
	}
}

func main() {
	fmt.Println(numberOfWays("SSPPSPS")) //=> 3
	fmt.Println(numberOfWays("PPSPSP"))  //=> 1
	fmt.Println(numberOfWays("S"))       //=> 0
}
