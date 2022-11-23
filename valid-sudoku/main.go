package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	run("in01")
	run("in02")
	run("in03")
}

func run(path string) {
	f, err := os.Open(path)
	if err != nil {
		panic(err)
	}
	defer f.Close()

	scanner := bufio.NewScanner(f)
	board := [][]byte{}
	for scanner.Scan() {
		row := []byte{}
		for _, token := range strings.Split(scanner.Text(), ",") {
			row = append(row, []byte(token)[1])
		}
		board = append(board, row)
	}

	fmt.Println(isValidSudoku(board))
}

func isValidSudoku(board [][]byte) bool {
	for i := 0; i < 9; i++ {
		a := []byte{}
		for j := 0; j < 9; j++ {
			a = append(a, board[i][j])
		}
		if !isValid(a) {
			return false
		}
	}

	for j := 0; j < 9; j++ {
		a := []byte{}
		for i := 0; i < 9; i++ {
			a = append(a, board[i][j])
		}
		if !isValid(a) {
			return false
		}
	}

	d := map[string][]byte{}
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			key := fmt.Sprintf("%v-%v", i/3, j/3)
			if _, ok := d[key]; !ok {
				d[key] = []byte{}
			}
			d[key] = append(d[key], board[i][j])
		}
	}

	for _, a := range d {
		if !isValid(a) {
			return false
		}
	}

	return true
}

func isValid(a []byte) bool {
	d := map[byte]bool{}
	for _, ch := range a {
		if ch == '.' {
			continue
		}
		if d[ch] {
			return false
		}
		d[ch] = true
	}
	return true
}
