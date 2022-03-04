package main

import "fmt"

func champagneTower(poured int, query_row int, query_glass int) float64 {
	d := []float64{float64(poured)}
	for i := 1; i <= query_row; i++ {
		e := make([]float64, i+1)
		for j := 0; j < len(d); j++ {
			v := d[j] - 1
			if v > 0 {
				e[j] += v / 2
				e[j+1] += v / 2
			}
		}
		d = e
	}

	if d[query_glass] > 1 {
		return 1
	} else {
		return d[query_glass]
	}
}

func main() {
	// fmt.Println(champagneTower(1, 1, 1))
	// fmt.Println(champagneTower(2, 1, 1))
	// fmt.Println(champagneTower(100000009, 33, 17))
	fmt.Println(champagneTower(25, 6, 1))
}
