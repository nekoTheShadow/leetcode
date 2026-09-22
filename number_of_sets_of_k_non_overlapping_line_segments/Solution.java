package number_of_sets_of_k_non_overlapping_line_segments;

import java.util.Arrays;

public class Solution {
    private static final long MOD = Math.powExact(10, 9) + 7;

    private int N;
    private int K;
    private long[][][] memo;

    public int numberOfSets(int n, int k) {
        this.N = n;
        this.K = k;
        this.memo = new long[N + 1][K + 1][2];
        for (long[][] x : memo) {
            for (long[] y : x) {
                Arrays.fill(y, -1);
            }
        }

        return (int) f(0, 0, false);
    }

    private long f(int pos, int count, boolean draw) {
        if (count == K) {
            return 1;
        }
        if (pos == N) {
            return 0;
        }

        if (memo[pos][count][draw ? 1 : 0] != -1) {
            return memo[pos][count][draw ? 1 : 0];
        }

        long ret = 0;
        ret += f(pos + 1, count, draw); // 何もしない
        ret %= MOD;

        if (draw) {
            // ひいている場合、ここでやめる権利がある
            ret += f(pos, count + 1, false);
        } else {
            // ひいていない場合、ここから始める
            ret += f(pos + 1, count, true);
        }
        ret %= MOD;

        memo[pos][count][draw ? 1 : 0] = ret;
        return ret;
    }
}
