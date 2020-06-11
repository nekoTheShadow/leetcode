package main

import "testing"

func TestExample(t *testing.T) {
	if shortestCommonSupersequence("abac", "cab") != "cabac" {
		t.Errorf(`shortestCommonSupersequence("abac", "cab") -->  expected "cabac", actual "%v"`, shortestCommonSupersequence("abac", "cab"))
	}
}
