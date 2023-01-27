package concatenated_words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findAllConcatenatedWordsInADict(new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
        System.out.println(new Solution().findAllConcatenatedWordsInADict(new String[] {"cat","dog","catdog"}));
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length));
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (this.solve(word, set)) {
                ans.add(word);
            }
            set.add(word);
        }
        return ans;
    }
    
    public boolean solve(String target, Set<String> set) {
        int n = target.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (dp[i] && set.contains(target.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[n];
    }
}
