package climbing_stairs_ii;

import java.util.Arrays;

public class Solution {
    private int solve(int[] costs) {
        int n = costs.length;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int d = 1; d <= 3; d++) {
                int j = i + d;
                if (j < n) {
                    dp[j] = Math.min(dp[j], dp[i] + costs[j] + d * d);
                }
            }
        }
        return dp[n - 1];
    }

    public int climbStairs(int n, int[] costs) {
        int[] p = new int[n + 1];
        System.arraycopy(costs, 0, p, 1, n);
        return solve(p);
    }

}
