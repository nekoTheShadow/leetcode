package main

import (
	"fmt"
	"math/bits"
)

func hammingWeight(num uint32) int {
	return bits.OnesCount32(num)
}

func main() {
	fmt.Println(hammingWeight(0b00000000000000000000000000001011))
	fmt.Println(hammingWeight(0b00000000000000000000000010000000))
	fmt.Println(hammingWeight(0b11111111111111111111111111111101))
}
