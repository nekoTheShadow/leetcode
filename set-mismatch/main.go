package main

func findErrorNums(nums []int) []int {
	ans := []int{}

	counter := map[int]int{}
	for _, num := range nums {
		counter[num]++
		if counter[num] > 1 {
			ans = append(ans, num)
		}
	}

	for i := 1; i <= len(nums); i++ {
		if _, ok := counter[i]; !ok {
			ans = append(ans, i)
		}
	}

	return ans
}
