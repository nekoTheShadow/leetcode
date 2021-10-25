package longest_substring_without_repeating_characters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://qiita.com/drken/items/ecd1a472d3a0e7db8dce
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int right = 0;
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for (int left = 0; left < n; left++) {
            while (right < n && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            
            ans = Math.max(ans, right-left);
            
            if (right==left) {
                right++;
            } else {
                set.remove(s.charAt(left));
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new Solution().lengthOfLongestSubstring(stdin.readLine()));
    }
}
