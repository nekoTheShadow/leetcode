package main

import "fmt"

func maximumEvenSplit(finalSum int64) []int64 {
	if finalSum%2 == 1 {
		return []int64{}
	}

	a := []int64{}
	sum := int64(0)
	for i := int64(2); sum+i <= finalSum; i += 2 {
		a = append(a, i)
		sum += i
	}

	a[len(a)-1] = a[len(a)-1] + finalSum - sum
	return a
}

func main() {
	fmt.Println(maximumEvenSplit(12))
	fmt.Println(maximumEvenSplit(7))
	fmt.Println(maximumEvenSplit(28))
}
