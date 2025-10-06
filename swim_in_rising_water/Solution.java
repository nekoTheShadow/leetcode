package swim_in_rising_water;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int inf = 1_000_000_000 + 7;

        int[][] t = new int[n][n];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                t[x][y] = inf;
            }
        }
        t[0][0] = grid[0][0];

        PriorityQueue<Key> pq = new PriorityQueue<>(Comparator.comparingInt(Key::t));
        pq.add(new Key(0, 0, t[0][0]));
        while (pq.poll() instanceof Key(int x1, int y1, int t1)) {
            if (t[x1][y1] < t1) {
                continue;
            }
            for (int[] d : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                int x2 = x1 + d[0];
                int y2 = y1 + d[1];
                if (!(0 <= x2 && x2 < n && 0 <= y2 && y2 < n)) {
                    continue;
                }

                int t2 = Math.max(t1, grid[x2][y2]);
                if (t2 < t[x2][y2]) {
                    t[x2][y2] = t2;
                    pq.add(new Key(x2, y2, t2));
                }
            }
        }
        return t[n - 1][n - 1];
    }
}

record Key(int x, int y, int t) {

}
