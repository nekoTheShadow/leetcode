package main

func sortArrayByParity(nums []int) []int {
	a := []int{}
	b := []int{}
	for _, num := range nums {
		if num%2 == 0 {
			a = append(a, num)
		} else {
			b = append(b, num)
		}
	}
	return append(a, b...)
}
