package find_all_possible_stable_binary_arrays_i;

import java.util.Arrays;

public class Solution {
    private static final int MOD = 1_000_000_000 + 7;

    private int limit;

    private int[][][] memo;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit = limit;
        this.memo = new int[zero + 1][one + 1][2];
        for (int[][] a : memo) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return (f(zero, one, 0) + f(zero, one, 1)) % MOD;
    }


    private int f(int zero, int one, int bit) {
        if (zero == 0) {
            return (bit == 0 && one <= limit) ? 1 : 0;
        }
        if (one == 0) {
            return (bit == 1 && zero <= limit) ? 1 : 0;
        }

        if (memo[zero][one][bit] != -1) {
            return memo[zero][one][bit];
        }

        int ret = 0;
        if (bit == 0) {
            for (int i = 1; i <= Math.min(limit, one); i++) {
                ret += f(zero, one - i, 1);
                ret %= MOD;
            }
        }
        if (bit == 1) {
            for (int i = 1; i <= Math.min(limit, zero); i++) {
                ret += f(zero - i, one, 0);
                ret %= MOD;
            }
        }

        memo[zero][one][bit] = ret;
        return ret;
    }
}