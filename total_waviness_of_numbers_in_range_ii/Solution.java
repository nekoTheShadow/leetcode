package total_waviness_of_numbers_in_range_ii;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Key, Value> memo;
    private char[] digits;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        memo = new HashMap<>();
        digits = Long.toString(x).toCharArray();
        return dfs(0, 10, 10, true, true).wavinessSum();
    }

    private Value dfs(int pos, int prev2, int prev1, boolean leadingZero, boolean tight) {
        if (pos == digits.length) {
            return new Value(1L, 0L);
        }

        Key key = new Key(pos, prev2, prev1, leadingZero, tight);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int limit = tight ? digits[pos] - '0' : 9;

        long totalCount = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {
            boolean nextTight = tight && d == limit;

            if (leadingZero && d == 0) {
                Value next = dfs(pos + 1, 10, 10, true, nextTight);
                totalCount += next.count();
                totalSum += next.wavinessSum();

            } else {
                long add = 0;
                if (!leadingZero && prev2 != 10) {
                    if ((prev2 < prev1 && prev1 > d) || (prev2 > prev1 && prev1 < d)) {
                        add = 1;
                    }
                }

                
                int nextPrev2 = leadingZero ? 10 : prev1;
                Value next = dfs(pos + 1, nextPrev2, d, false, nextTight);
                totalCount += next.count();
                totalSum += next.wavinessSum() + add * next.count();
            }
        }

        Value result = new Value(totalCount, totalSum);
        memo.put(key, result);
        return result;
    }

}

record Key(int pos, int prev2, int prev1, boolean leadingZero, boolean tight) {
}

record Value(long count, long wavinessSum) {
}