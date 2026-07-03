package find_a_safe_walk_through_a_grid;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int h = grid.size();
        int w = grid.getFirst().size();

        int[][] dist = new int[h][w];
        for (int[] r : dist) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        dist[0][0] = grid.get(0).get(0);

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int x = cur[0];
            int y = cur[1];
            for (int[] diff : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                int nx = x + diff[0];
                int ny = y + diff[1];
                if (0 <= nx && nx < h && 0 <= ny && ny < w && dist[x][y] + grid.get(nx).get(ny) < dist[nx][ny]) {
                    dist[nx][ny] = dist[x][y] + grid.get(nx).get(ny);
                    if (grid.get(nx).get(ny) == 0) {
                        q.addFirst(new int[]{nx, ny});
                    } else {
                        q.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
        return health - dist[h - 1][w - 1] >= 1;
    }
}
