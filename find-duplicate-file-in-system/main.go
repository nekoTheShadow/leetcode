package main

import (
	"fmt"
	"strings"
)

func findDuplicate(paths []string) [][]string {
	d := map[string][]string{}
	for _, path := range paths {
		tokens := strings.Split(path, " ")
		for _, file := range tokens[1:] {
			i1 := strings.Index(file, "(")
			i2 := strings.Index(file, ")")

			filename := file[:i1]
			content := file[i1+1 : i2]
			if _, ok := d[content]; !ok {
				d[content] = []string{}
			}
			d[content] = append(d[content], tokens[0]+`/`+filename)
		}
	}

	ret := [][]string{}
	for _, v := range d {
		if len(v) > 1 {
			ret = append(ret, v)
		}
	}
	return ret
}

func main() {
	fmt.Println(findDuplicate([]string{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}))
	fmt.Println(findDuplicate([]string{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)"}))
}
