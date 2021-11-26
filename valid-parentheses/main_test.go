package main

import "testing"

func TestIsValid(t *testing.T) {
	tests := []struct {
		s    string
		want bool
	}{
		{s: "()", want: true},
		{s: "()[]{}", want: true},
		{s: "(]", want: false},
		{s: "([)]", want: false},
		{s: "{[]}", want: true},
		{s: "[", want: false},
	}

	for _, tt := range tests {
		if got := isValid(tt.s); got != tt.want {
			t.Errorf("isValid(`%v`) ... want: %v, got:%v", tt.s, tt.want, got)
		}
	}
}
