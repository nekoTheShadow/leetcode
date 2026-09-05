package find_the_safest_path_in_a_grid;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {
    List<Tuple> diffs = List.of(new Tuple(0, 1), new Tuple(0, -1), new Tuple(1, 0), new Tuple(-1, 0));

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }


        Deque<Tuple> q = new ArrayDeque<>();
        int[][] dist = new int[n][n];
        for (int[] r : dist) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.addLast(new Tuple(i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            Tuple cur = q.removeFirst();
            for (Tuple diff : diffs) {
                int nx = cur.x() + diff.x();
                int ny = cur.y() + diff.y();
                if (0 <= nx && nx < n && 0 <= ny && ny < n && dist[cur.x()][cur.y()] + 1 < dist[nx][ny]) {
                    dist[nx][ny] = dist[cur.x()][cur.y()] + 1;
                    q.addLast(new Tuple(nx, ny));
                }
            }
        }


        int ok = -1;
        int ng = 2 * n + 1;
        while (Math.abs(ok - ng) > 1) {
            int mi = (ok + ng) / 2;

            boolean[][] visited = new boolean[n][n];
            Deque<Tuple> stack = new ArrayDeque<>();

            if (dist[0][0] >= mi) {
                stack.addLast(new Tuple(0, 0));
                visited[0][0] = true;
            }

            while (!stack.isEmpty()) {
                Tuple cur = stack.removeLast();
                for (Tuple diff : diffs) {
                    int nx = cur.x() + diff.x();
                    int ny = cur.y() + diff.y();
                    if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny] && dist[nx][ny] >= mi) {
                        stack.addLast(new Tuple(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }


            if (visited[n - 1][n - 1]) {
                ok = mi;
            } else {
                ng = mi;
            }
        }

        return ok;
    }
}

record Tuple(int x, int y) {

}
