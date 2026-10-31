package count_islands_with_total_value_divisible_by_k;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int countIslands(int[][] grid, int k) {
        int h = grid.length;
        int w = grid[0].length;
        boolean[][] visited = new boolean[h][w];
        int ans = 0;
        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                if (grid[x][y] == 0 || visited[x][y]) {
                    continue;
                }

                Deque<int[]> stack = new ArrayDeque<>();
                int total = 0;

                total = (total + grid[x][y]) % k;
                stack.addLast(new int[]{x, y});
                visited[x][y] = true;
                while (!stack.isEmpty()) {
                    int[] pos = stack.pop();
                    for (int[] diff : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                        int nx = pos[0] + diff[0];
                        int ny = pos[1] + diff[1];
                        if (0 <= nx && nx < h && 0 <= ny & ny < w && grid[nx][ny] != 0 && !visited[nx][ny]) {
                            total = (total + grid[nx][ny]) % k;
                            stack.addLast(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }

                if (total % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
