package equal_sum_grid_partition_ii;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long[][] marix = toLongMatrix(grid);
        for (int i = 0; i < 4; i++) {
            if (check(marix)) {
                return true;
            }
            marix = rotate(marix);
        }
        return false;
    }

    public boolean check(long[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        if (h < 2) {
            return false;
        }

        long total = Arrays.stream(grid).mapToLong(row -> Arrays.stream(row).sum()).sum();
        long prefix = 0;
        Set<Long> seen = new HashSet<>();

        for (int i = 0; i < h - 1; i++) {
            Arrays.stream(grid[i]).forEach(seen::add);
            prefix += Arrays.stream(grid[i]).sum();

            long target = 2L * prefix - total;
            if (target == 0) {
                return true;
            }
            if (target > 0) {
                if (i == 0) {
                    if (w == 1) {
                        if (grid[0][0] == target) {
                            return true;
                        }
                    } else {
                        if (grid[0][0] == target || grid[0][w - 1] == target) {
                            return true;
                        }
                    }
                } else if (w == 1) {
                    if (grid[0][0] == target || grid[i][0] == target) {
                        return true;
                    }
                } else {
                    if (seen.contains(target)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public long[][] rotate(long[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        long[][] rotated = new long[w][h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                rotated[j][h - 1 - i] = grid[i][j];
            }
        }
        return rotated;
    }

    public long[][] toLongMatrix(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        long[][] matrix = new long[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                matrix[i][j] = grid[i][j];
            }
        }
        return matrix;
    }
}
