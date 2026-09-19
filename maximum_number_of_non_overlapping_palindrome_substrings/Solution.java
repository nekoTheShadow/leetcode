package maximum_number_of_non_overlapping_palindrome_substrings;

import java.util.stream.IntStream;

public class Solution {
    public int maxPalindromes(String s, int k) {
        int ans = 0;
        int start = 0;
        int len = s.length();
        while (start < len) {
            if (start + k <= len && check(s.substring(start, start + k))) {
                start += k;
                ans++;
                continue;
            }
            
            if (start + k + 1 <= len && check(s.substring(start, start + k + 1))) {
                start += k + 1;
                ans++;
                continue;
            }

            start++;
        }
        return ans;
    }

    private boolean check(String s) {
        int n = s.length();
        return IntStream.range(0, n / 2).allMatch(i -> s.charAt(i) == s.charAt(n - i - 1));
    }
}
