package distinct_subsequences;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private String s;
    private String t;
    private Map<Key, Integer> memo;

    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        this.memo = new HashMap<>();
        return f(0, 0);
    }

    private int f(int x, int y) {
        if (y == t.length()) {
            return 1;
        }
        if (x == s.length()) {
            return 0;
        }

        Key key = new Key(x, y);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (s.charAt(x) == t.charAt(y)) {
            int v1 = f(x + 1, y + 1); // take
            int v2 = f(x + 1, y); // skip
            memo.put(key, v1 + v2);
            return v1 + v2;
        } else {
            int v2 = f(x + 1, y); // skip;
            memo.put(key, v2);
            return v2;
        }
    }
}

record Key(int x, int y) {

}
