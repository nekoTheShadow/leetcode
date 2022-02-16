package main

import "fmt"

func maxScoreIndices(nums []int) []int {
	l0 := 0
	l1 := 0
	r0 := 0
	r1 := 0
	for _, num := range nums {
		if num == 0 {
			r0++
		} else {
			r1++
		}
	}

	scores := []int{}
	for i := 0; i <= len(nums); i++ {
		scores = append(scores, l0+r1)
		if i < len(nums) {
			if nums[i] == 0 {
				l0++
				r0--
			} else {
				l1++
				r1--
			}
		}
	}

	max := 0
	for _, score := range scores {
		if max < score {
			max = score
		}
	}

	answers := []int{}
	for i, score := range scores {
		if score == max {
			answers = append(answers, i)
		}
	}
	return answers
}

func main() {
	fmt.Println(maxScoreIndices([]int{0, 0, 1, 0})) //=> [2,4]
	fmt.Println(maxScoreIndices([]int{0, 0, 0}))    //=> [3]
}
