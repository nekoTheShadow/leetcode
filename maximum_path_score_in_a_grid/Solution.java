package maximum_path_score_in_a_grid;

import java.util.Arrays;

public class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int h = grid.length;
        int w = grid[0].length;

        int[][][] score = new int[h][w][k + 1];
        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                for (int z = 0; z <= k; z++) {
                    score[x][y][z] = -1;
                }
            }
        }

        if (cost(grid[0][0]) <= k) {
            score[0][0][cost(grid[0][0])] = grid[0][0];
        }

        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                for (int z = 0; z <= k; z++) {
                    if (score[x][y][z] == -1) {
                        continue;
                    }

                    for (int[] diff : new int[][]{{1, 0}, {0, 1}}) {
                        int nx = x + diff[0];
                        int ny = y + diff[1];
                        if (!(0 <= nx && nx < h && 0 <= ny && ny < w)) {
                            continue;
                        }
                        if (z + cost(grid[nx][ny]) <= k) {
                            score[nx][ny][z + cost(grid[nx][ny])] = Math.max(score[nx][ny][z + cost(grid[nx][ny])], score[x][y][z] + grid[nx][ny]);
                        }
                    }
                }
            }
        }

        return Arrays.stream(score[h - 1][w - 1]).max().getAsInt();
    }

    private int cost(int cell) {
        return cell == 0 ? 0 : 1;
    }
}
