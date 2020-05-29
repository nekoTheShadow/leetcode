package main

import (
	"testing"
)

func TestExample1(t *testing.T) {
	skiplist := Constructor()
	skiplist.Add(1)
	skiplist.Add(2)
	skiplist.Add(3)
	if skiplist.Search(0) {
		t.Fatalf("skiplist.Search(0): expected false, actual true")
	}
	skiplist.Add(4)
	if !skiplist.Search(1) {
		t.Fatalf("skiplist.Search(1): expected true, actual false")
	}
	if skiplist.Erase(0) {
		t.Fatalf("skiplist.Erase(0): expected false, actual true")
	}
	if !skiplist.Erase(1) {
		t.Fatalf("skiplist.Erase(1): expected true, actual false")
	}
	if skiplist.Search(1) {
		t.Fatalf("skiplist.Search(1): expected false, actual true")
	}
}

func TestExample2(t *testing.T) {
	skiplist := Constructor()
	skiplist.Add(1)
	skiplist.Add(2)
	skiplist.Add(3)
	if skiplist.Search(0) {
		t.Fatalf("skiplist.Search(0): expected false, actual true")
	}
	skiplist.Add(4)
	if !skiplist.Search(1) {
		t.Fatalf("skiplist.Search(1): expected true, actual false")
	}
	skiplist.Add(5)
	if !skiplist.Search(3) {
		t.Fatalf("skiplist.Search(3): expected true, actual false")
	}
	if skiplist.Search(6) {
		t.Fatalf("skiplist.Search(6): expected false, actual true")
	}
}
