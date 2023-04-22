package minimum_insertion_steps_to_make_a_string_palindrome;

public class Solution {
    public int minInsertions(String s) {
        String t = lcs(s, new StringBuilder(s).reverse().toString());
        return s.length()-t.length();
    }
    
    public String lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int x = n;
        int y = m;
        StringBuilder u = new StringBuilder();
        while(x > 0 && y > 0) {
            if (dp[x][y] == dp[x-1][y]) {
                x--;
            } else if (dp[x][y] == dp[x][y-1]) {
                y--;
            } else {
                x--;
                y--;
                u.append(s.charAt(x));
            }
        }

        return u.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minInsertions("zzazz"));
        System.out.println(new Solution().minInsertions("mbadm"));
        System.out.println(new Solution().minInsertions("leetcode"));
        System.out.println(new Solution().minInsertions("zjveiiwvc"));
    }
}
