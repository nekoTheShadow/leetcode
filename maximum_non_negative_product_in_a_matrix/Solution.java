package maximum_non_negative_product_in_a_matrix;

public class Solution {
    public int maxProductPath(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;

        long[][] pos = new long[h][w];
        long[][] neg = new long[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                pos[i][j] = -1;
                neg[i][j] = -1;
            }
        }

        if (grid[0][0] >= 0) {
            pos[0][0] = grid[0][0];
        }
        if (grid[0][0] <= 0) {
            neg[0][0] = -grid[0][0];
        }


        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int[] d : new int[][]{{0, 1}, {1, 0}}) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (!(x < h && y < w)) {
                        continue;
                    }
                    if (grid[x][y] >= 0) {
                        if (pos[i][j] != -1) {
                            pos[x][y] = Math.max(pos[x][y], pos[i][j] * grid[x][y]);
                        }
                        if (neg[i][j] != -1) {
                            neg[x][y] = Math.max(neg[x][y], neg[i][j] * grid[x][y]);
                        }
                    }
                    if (grid[x][y] <= 0) {
                        if (neg[i][j] != -1) {
                            pos[x][y] = Math.max(pos[x][y], neg[i][j] * -grid[x][y]);
                        }
                        if (pos[i][j] != -1) {
                            neg[x][y] = Math.max(neg[x][y], pos[i][j] * -grid[x][y]);
                        }
                    }
                }
            }
        }

        return (int) (pos[h - 1][w - 1] % (1_000_000_000 + 7));
    }


}
