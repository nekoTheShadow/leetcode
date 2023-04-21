
package profitable_schemes;

public class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        long mod = (long)1e9 + 7;
        
        // dp[何個目の犯罪][利用した人数][得た利益]
        long[][][] dp = new long[profit.length+1][n+1][minProfit+1];
        dp[0][0][0] = 1;
        
        for (int i = 0; i < profit.length; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    // 何もしない
                    dp[i+1][j][k] += dp[i][j][k];
                    dp[i+1][j][k] %= mod;
                    
                    // 犯罪を行う
                    if (j+group[i] <= n) {
                        dp[i+1][j+group[i]][Math.min(k+profit[i], minProfit)] += dp[i][j][k];
                        dp[i+1][j+group[i]][Math.min(k+profit[i], minProfit)] %= mod;
                    }
                }
            }
        }
        
        long sum = 0;
        for (int j = 0; j <= n; j++) {
            sum += dp[profit.length][j][minProfit];
            sum %= mod;
        }
        return (int)sum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().profitableSchemes(5, 3, new int[] {2,2}, new int[] {2,3}));
        System.out.println(new Solution().profitableSchemes(10, 5, new int[] {2,3,5}, new int[] {6,7,8}));
    }
}
