package minimum_falling_path_sum_ii;

import java.util.Arrays;

public class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n+1][m];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (j != k) {
                        dp[i+1][k] = Math.min(dp[i+1][k], dp[i][j]+arr[i][j]);
                    }
                }
            }
        }

        return Arrays.stream(dp[n]).min().getAsInt();
    }
}
