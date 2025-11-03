package sort_matrix_by_diagonals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        for (int x = 0; x < h; x++) {
            sort(grid, x, 0, false);
        }
        for (int y = 1; y < w; y++) {
            sort(grid, 0, y, true);
        }
        return grid;
    }

    private void sort(int[][] grid, int sx, int sy, boolean asc) {
        int h = grid.length;
        int w = grid[0].length;

        List<Integer> values = new ArrayList<>();
        int x1 = sx;
        int y1 = sy;
        while (x1 < h && y1 < w) {
            values.add(grid[x1++][y1++]);
        }

        Collections.sort(values);
        if (!asc) {
            Collections.reverse(values);
        }
        
        int x2 = sx;
        int y2 = sy;
        for (int value : values) {
            grid[x2++][y2++] = value;
        }
    }
}
