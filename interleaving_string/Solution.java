package interleaving_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.memo = new HashMap<>();
        return dfs(0, 0, 0);
    }

    private String s1;
    private String s2;
    private String s3;
    private Map<List<Integer>, Boolean> memo;

    public boolean dfs(int x, int y, int z) {
        if (z == s3.length()) {
            return true;
        }

        List<Integer> key = Arrays.asList(x, y, z);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (x == s1.length()) {
            memo.put(key, s2.charAt(y) == s3.charAt(z) && dfs(x, y+1, z+1));
        } else if (y == s2.length()) {
            memo.put(key, s1.charAt(x) == s3.charAt(z) && dfs(x+1, y, z+1));
        } else {
            char c1 = s1.charAt(x);
            char c2 = s2.charAt(y);
            char c3 = s3.charAt(z);

            if (c1 == c2) {
                memo.put(key, c1 == c3 && (dfs(x+1, y, z+1) || dfs(x, y+1, z+1)));
            } else if (c1 == c3) {
                memo.put(key, dfs(x+1, y, z+1));
            } else if (c2 == c3) {
                memo.put(key, dfs(x, y+1, z+1));
            } else {
                memo.put(key, false);
            }
        }

        return memo.get(key);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
