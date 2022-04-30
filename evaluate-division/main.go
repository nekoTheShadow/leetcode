package main

import "fmt"

func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
	g := map[string]map[string]float64{}
	for i, equation := range equations {
		x := equation[0]
		y := equation[1]
		if _, ok := g[x]; !ok {
			g[x] = map[string]float64{}
		}
		if _, ok := g[y]; !ok {
			g[y] = map[string]float64{}
		}
		g[x][y] = values[i]
		g[y][x] = 1 / values[i]
	}

	ans := []float64{}
	for _, query := range queries {
		s := query[0]
		t := query[1]
		if _, ok := g[s]; !ok {
			ans = append(ans, -1)
			continue
		}

		dist := map[string]float64{s: 1}
		stack := []string{s}
		for len(stack) > 0 {
			cur := stack[0]
			stack = stack[1:]

			if _, ok := g[cur]; !ok {
				continue
			}
			for nxt, cost := range g[cur] {
				if _, ok := dist[nxt]; ok {
					continue
				}
				dist[nxt] = dist[cur] * cost
				stack = append(stack, nxt)
			}
		}

		if _, ok := dist[t]; ok {
			ans = append(ans, dist[t])
		} else {
			ans = append(ans, -1)
		}
	}

	return ans
}

func main() {
	fmt.Println(calcEquation(
		[][]string{{"a", "b"}, {"b", "c"}},
		[]float64{2.0, 3.0},
		[][]string{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}},
	))

	fmt.Println(calcEquation(
		[][]string{{"a", "b"}, {"b", "c"}, {"bc", "cd"}},
		[]float64{1.5, 2.5, 5.0},
		[][]string{{"a", "c"}, {"c", "b"}, {"bc", "cd"}, {"cd", "bc"}},
	))

	fmt.Println(calcEquation(
		[][]string{{"a", "b"}},
		[]float64{0.5},
		[][]string{{"a", "b"}, {"b", "a"}, {"a", "c"}, {"x", "y"}},
	))
}
