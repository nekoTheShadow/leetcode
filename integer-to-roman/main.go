package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(intToRoman(3))
	fmt.Println(intToRoman(58))
	fmt.Println(intToRoman(1994))
}

func intToRoman(num int) string {
	dict := map[int]string{
		0:    "",
		1:    "I",
		2:    "II",
		3:    "III",
		4:    "IV",
		5:    "V",
		6:    "VI",
		7:    "VII",
		8:    "VIII",
		9:    "IX",
		10:   "X",
		20:   "XX",
		30:   "XXX",
		40:   "XL",
		50:   "L",
		60:   "LX",
		70:   "LXX",
		80:   "LXXX",
		90:   "XC",
		100:  "C",
		200:  "CC",
		300:  "CCC",
		400:  "CD",
		500:  "D",
		600:  "DC",
		700:  "DCC",
		800:  "DCCC",
		900:  "CM",
		1000: "M",
		2000: "MM",
		3000: "MMM",
	}

	romes := []string{}
	base := 1
	for num > 0 {
		romes = append(romes, dict[(num%10)*base])

		num /= 10
		base *= 10
	}

	var ans strings.Builder
	for i := len(romes) - 1; i >= 0; i-- {
		ans.WriteString(romes[i])
	}
	return ans.String()
}
