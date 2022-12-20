package main

func canVisitAllRooms(rooms [][]int) bool {
	visited := make([]bool, len(rooms))
	que := []int{0}
	for len(que) > 0 {
		cur := que[0]
		que = que[1:]

		visited[cur] = true
		for _, nxt := range rooms[cur] {
			if !visited[nxt] {
				que = append(que, nxt)
			}
		}
	}

	for i := 0; i < len(visited); i++ {
		if !visited[i] {
			return false
		}
	}
	return true
}
