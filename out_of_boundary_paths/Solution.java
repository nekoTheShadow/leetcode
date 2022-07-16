package out_of_boundary_paths;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findPaths(2, 2, 2, 0, 0));
        System.out.println(new Solution().findPaths(1, 3, 3, 0, 1));
        System.out.println(new Solution().findPaths(10, 10, 11, 5, 5));
    }


    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.M = m;
        this.N = n;
        this.MOD = 1000000000 + 7;
        this.MEMO = new int[m][n][maxMove+1];

        for (int[][] rows : this.MEMO) {
            for (int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }

        return this.dfs(startRow, startColumn, maxMove);
    }

    private int M;
    private int N;
    private int MOD;
    private int[][][] MEMO;

    private int dfs(int x, int y, int move) {
        if (!(0<=x && x<M && 0<=y && y<N)) {
            return 1;
        }

        if (move == 0) {
            return 0;
        }

        if (MEMO[x][y][move] != -1) {
            return MEMO[x][y][move];
        }

        int ans = 0;
        for (int[] diff : new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
            ans += dfs(x+diff[0], y+diff[1], move-1);
            ans %= MOD;
        }
        MEMO[x][y][move] = ans;
        return ans;
    }
}
