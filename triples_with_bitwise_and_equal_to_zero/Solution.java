package triples_with_bitwise_and_equal_to_zero;

public class Solution {
    public int countTriplets(int[] A) {
        int n = 3;
        int m = 1 << 16;
        int[][] dp = new int[n][m];
        for (int a : A) {
            dp[0][a] += 1;
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m; j++) {
                for (int a : A) {
                    dp[i+1][j&a] += dp[i][j];
                }
            }
        }

        return dp[n-1][0];
    }
}
