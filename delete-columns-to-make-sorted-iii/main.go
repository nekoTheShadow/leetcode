package main

func minDeletionSize(A []string) int {
	n := len(A[0])
	dp := make([]int, n)
	for i := 0; i < n; i++ {
		dp[i] = 1
	}

	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			ok := true
			for _, a := range A {
				if a[i] > a[j] {
					ok = false
				}
			}

			if ok {
				dp[j] = Max(dp[j], dp[i]+1)
			}
		}
	}

	return n - Max(dp[0], dp[1:]...)
}

func Max(a int, b ...int) int {
	for _, v := range b {
		if a < v {
			a = v
		}
	}
	return a
}
