package xor_after_range_multiplication_queries_ii;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static final int MOD = 1_000_000_007;

    private int inv(int x) {
        return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(MOD)).intValue();
    }

    private int mul(int x, int y) {
        return (int) ((long) x * (long) y % (long) MOD);
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int T = (int) Math.sqrt(n);
        List<List<LRV>> groups = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            groups.add(new ArrayList<>());
        }

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];
            if (k < T) {
                groups.get(k).add(new LRV(l, r, v));
            } else {
                for (int i = l; i <= r; i += k) {
                    nums[i] = mul(nums[i], v);
                }
            }
        }

        int[] dif = new int[n + T];
        for (int k = 1; k < T; k++) {
            Arrays.fill(dif, 1);
            for (LRV lrv : groups.get(k)) {
                int l = lrv.l();
                int r = lrv.r();
                int v = lrv.v();

                dif[l] = mul(dif[l], v);
                int R = ((r - l) / k + 1) * k + l;
                dif[R] = mul(dif[R], inv(v));
            }

            for (int i = k; i < n; i++) {
                dif[i] = mul(dif[i], dif[i - k]);
            }
            for (int i = 0; i < n; i++) {
                nums[i] = mul(nums[i], dif[i]);
            }
        }

        return Arrays.stream(nums).reduce(0, (acc, v) -> acc ^ v);
    }
}

record LRV(int l, int r, int v) {

}