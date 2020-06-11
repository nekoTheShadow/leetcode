package main

import (
	"reflect"
	"testing"
)

func TestExample(t *testing.T) {
	nums := []int{2, 7, 11, 15}
	target := 9
	expected := []int{0, 1}
	actual := twoSum(nums, target)
	if !reflect.DeepEqual(expected, actual) {
		t.FailNow()
	}
}
