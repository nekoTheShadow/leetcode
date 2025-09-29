package minimum_score_triangulation_of_polygon;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int[] values;
    private Map<Key, Integer> memo;

    public int minScoreTriangulation(int[] values) {
        this.values = values;
        this.memo = new HashMap<>();
        return dp(0, values.length - 1);
    }

    private int dp(int i, int j) {
        if (i + 2 > j) {
            return 0;
        }
        if (i + 2 == j) {
            return values[i] * values[i + 1] * values[i + 2];
        }

        Key key = new Key(i, j);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int v = values[i] * values[k] * values[j] + dp(i, k) + dp(k, j);
            min = Math.min(min, v);
        }
        memo.put(key, min);
        return min;
    }
}

record Key(int i, int j) {
}