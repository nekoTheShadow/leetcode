package main

import (
	"fmt"
	"regexp"
	"strconv"
)

func isPowerOfThree(n int) bool {
	return n > 0 && regexp.MustCompile("^10*?$").MatchString(strconv.FormatInt(int64(n), 3))
}

func main() {
	fmt.Println(isPowerOfThree(27))
	fmt.Println(isPowerOfThree(0))
	fmt.Println(isPowerOfThree(9))
}
