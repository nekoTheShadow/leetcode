package longest_chunked_palindrome_decomposition;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestDecomposition(String text) {
        return f(text);
    }

    private Map<String, Integer> memo = new HashMap<>();

    private int f(String cur) {
        if (cur.isEmpty()) {
            return 0;
        }

        if (memo.containsKey(cur)) {
            return memo.get(cur);
        }

        int ans = 1;
        for (int i = 1; i < cur.length(); i++) {
            String prefix = cur.substring(0, i);
            if (!cur.endsWith(prefix)) {
                continue;
            }

            int begin = prefix.length();
            int end = cur.length() - prefix.length();
            if (begin <= end) {
                String nxt = cur.substring(begin, end);
                ans = Math.max(ans, f(nxt) + 2);
            }

        }

        memo.put(cur, ans);
        return ans;
    }
}
