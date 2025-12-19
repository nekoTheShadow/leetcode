package best_time_to_buy_and_sell_stock_v;

import java.util.Arrays;

public class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] dp = new long[n + 1][k + 1][3];
        for (long[][] a : dp) {
            for (long[] b : a) {
                Arrays.fill(b, Long.MIN_VALUE);
            }
        }
        dp[0][0][0] = 0;

        for (int day = 0; day < n; day++) {
            for (int t = 0; t < k; t++) {
                if (dp[day][t][0] != Long.MIN_VALUE) {
                    dp[day + 1][t][0] = Math.max(dp[day + 1][t][0], dp[day][t][0]);
                    dp[day + 1][t][1] = Math.max(dp[day + 1][t][1], dp[day][t][0] - prices[day]);
                    dp[day + 1][t][2] = Math.max(dp[day + 1][t][2], dp[day][t][0] + prices[day]);
                }

                if (dp[day][t][1] != Long.MIN_VALUE) {
                    dp[day + 1][t][1] = Math.max(dp[day + 1][t][1], dp[day][t][1]);
                    dp[day + 1][t + 1][0] =
                            Math.max(dp[day + 1][t + 1][0], dp[day][t][1] + prices[day]);
                }

                if (dp[day][t][2] != Long.MIN_VALUE) {
                    dp[day + 1][t][2] = Math.max(dp[day + 1][t][2], dp[day][t][2]);
                    dp[day + 1][t + 1][0] =
                            Math.max(dp[day + 1][t + 1][0], dp[day][t][2] - prices[day]);
                }
            }
        }

        long max = Long.MIN_VALUE;
        for (int day = 0; day <= n; day++) {
            for (int t = 0; t <= k; t++) {
                max = Math.max(max, dp[day][t][0]);
            }
        }
        return max;
    }
}


class Test {
    void main() {
        Solution s = new Solution();
        assert s.maximumProfit(new int[]{1, 7, 9, 8, 2}, 2) == 14 : "Example1";
        assert s.maximumProfit(new int[]{12, 16, 19, 19, 8, 1, 19, 13, 9}, 3) == 36 : "Example2";
    }
}