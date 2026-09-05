package maximum_score_from_grid_operations;

import java.util.Arrays;

public class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        if (n == 1) {
            return 0;
        }

        long[] dp0 = new long[n + 1];
        long[] dp1 = new long[n + 1];
        for (int j = 1; j < n; j++) {
            long[] newdp0 = new long[n + 1];
            long[] newdp1 = new long[n + 1];
            for (int i = 0; i < n + 1; i++) {
                long prev = 0;
                long curr = 0;
                for (int x = 0; x < i; x++) {
                    curr += grid[x][j];
                }
                for (int y = 0; y < n + 1; y++) {
                    if (y > 0 && y <= i) {
                        curr -= grid[y - 1][j];
                    }
                    if (y > i) {
                        prev += grid[y - 1][j - 1];
                    }
                    newdp0[y] = max(newdp0[y], prev + dp0[i], dp1[i]);
                    newdp1[y] = max(newdp1[y], curr + dp1[i], curr + prev + dp0[i]);
                }
            }
            dp0 = newdp0;
            dp1 = newdp1;
        }
        return Arrays.stream(dp1).max().getAsLong();
    }

    private long max(long a, long b, long c) {
        return Math.max(a, Math.max(b, c));
    }
}
