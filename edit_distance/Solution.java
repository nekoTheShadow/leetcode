package edit_distance;

import java.util.stream.IntStream;

public class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int c = word1.charAt(i-1)==word2.charAt(j-1) ? 0 : 1;
                dp[i][j] = IntStream.of(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+c).min().getAsInt();
            }
        }
        return dp[n1][n2];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("horse", "ros"));
        System.out.println(new Solution().minDistance("intention", "execution"));
    }
}
