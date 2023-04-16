package number_of_ways_to_form_a_target_string_given_a_dictionary;

public class Solution {
    public int numWays(String[] words, String target) {
        int n = target.length();
        long mod = 1000000000+7;
        long[] dp = new long[n+1];
        dp[0] = 1;
        
        for (int i = 0; i < words[0].length(); i++) {
            long[] c = new long[26];
            for (String word : words) {
                c[word.charAt(i)-'a']++;
            }
            for (int j=n-1; j>=0; j--) {
                dp[j+1] += dp[j]*c[target.charAt(j)-'a'];
                dp[j+1] %= mod;
            }
        }
        
        return (int)dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numWays(new String[] {"acca","bbbb","caca"}, "aba"));
        System.out.println(new Solution().numWays(new String[] {"abba","baab"}, "bab"));
    }
}
