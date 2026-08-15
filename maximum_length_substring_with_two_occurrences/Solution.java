package maximum_length_substring_with_two_occurrences;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();

        Map<Character, Integer> dict = new HashMap<>();
        int ret = 0;
        int right = 0;
        for (int left = 0; left < n; left++) {
            while (right < n && dict.getOrDefault(s.charAt(right), 0) < 2) {
                dict.put(s.charAt(right), dict.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }

            ret = Math.max(ret, right - left);

            if (left == right) {
                right++;
            } else {
                dict.put(s.charAt(left), dict.get(s.charAt(left)) - 1);
            }
        }
        return ret;
    }
}