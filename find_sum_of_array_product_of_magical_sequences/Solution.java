package find_sum_of_array_product_of_magical_sequences;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final long MOD = 1_000_000_007;

    private ModuloNCR ncr;
    private int[] nums;
    private Map<State, Long> memo;

    public int magicalSum(int m, int k, int[] nums) {
        this.ncr = new ModuloNCR(m, MOD);
        this.nums = nums;
        this.memo = new HashMap<>();
        return (int) dp(m, k, 0, 0);
    }

    private long dp(int m, int k, int i, int carry) {
        if (m < 0 || k < 0 || m + Integer.bitCount(carry) < k) {
            return 0;
        }
        if (m == 0) {
            return k == Integer.bitCount(carry) ? 1 : 0;
        }
        if (i == nums.length) {
            return 0;
        }

        State state = new State(m, k, i, carry);
        if (memo.containsKey(state)) {
            return memo.get(state);
        }

        long total = 0;
        for (int count = 0; count <= m; count++) {
            long contribution = ncr.nCr(m, count) * pow(nums[i], count);
            contribution %= MOD;
            int newCarry = carry + count;
            total += dp(m - count, k - (newCarry % 2), i + 1, newCarry / 2) * contribution;
            total %= MOD;
        }

        memo.put(state, total);
        return total;
    }


    private long pow(long x, long y) {
        return BigInteger.valueOf(x).modPow(BigInteger.valueOf(y), BigInteger.valueOf(MOD)).longValue();
    }
}


class ModuloNCR {
    private final long[] f;
    private final long[] g;
    private final long mod;

    public ModuloNCR(int n, long mod) {
        this.mod = mod;

        f = new long[n + 1];
        g = new long[n + 1];
        f[0] = f[1] = 1;
        g[0] = g[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] * i % mod;
            g[i] = BigInteger.valueOf(f[i]).modInverse(BigInteger.valueOf(mod)).longValue();
        }
    }

    public long nCr(int n, int r) {
        return f[n] * (g[r] * g[n - r] % mod) % mod;
    }
}

record State(int m, int k, int i, int carry) {
}