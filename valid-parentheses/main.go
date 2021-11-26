package main

func isValid(s string) bool {
	stack := []rune{}
	for _, c := range s {
		if c == '(' || c == '{' || c == '[' {
			stack = append(stack, c)
		} else {
			if len(stack) == 0 {
				return false
			}

			b := stack[len(stack)-1]
			if !((b == '(' && c == ')') || (b == '[' && c == ']') || (b == '{' && c == '}')) {
				return false
			}

			stack = stack[0 : len(stack)-1]
		}
	}

	return len(stack) == 0
}
