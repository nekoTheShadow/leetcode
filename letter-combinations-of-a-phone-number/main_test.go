package main

import (
	"reflect"
	"sort"
	"testing"
)

func TestLetterCombinations(t *testing.T) {
	tests := []struct {
		digits string
		want   []string
	}{
		{
			digits: "23",
			want:   []string{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"},
		},
		{
			digits: "",
			want:   []string{},
		},
		{
			digits: "2",
			want:   []string{"a", "b", "c"},
		},
	}

	for _, tt := range tests {
		got := letterCombinations(tt.digits)
		sort.Strings(got)
		sort.Strings(tt.want)
		if !reflect.DeepEqual(got, tt.want) {
			t.Errorf("letterCombinations(%v) ... want: %v, got: %v", tt.digits, tt.want, got)
		}
	}
}
