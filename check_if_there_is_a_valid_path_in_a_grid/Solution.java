package check_if_there_is_a_valid_path_in_a_grid;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public final class Solution {
    public boolean hasValidPath(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;

        boolean[][] visited = new boolean[h][w];

        Map<Integer, List<Pair>> dirs = Map.of(
                1, List.of(new Pair(0, 1), new Pair(0, -1)),
                2, List.of(new Pair(1, 0), new Pair(-1, 0)),
                3, List.of(new Pair(0, -1), new Pair(1, 0)),
                4, List.of(new Pair(0, 1), new Pair(1, 0)),
                5, List.of(new Pair(0, -1), new Pair(-1, 0)),
                6, List.of(new Pair(0, 1), new Pair(-1, 0))
        );

        Deque<Pair> stack = new ArrayDeque<>();
        stack.addLast(new Pair(0, 0));
        while (!stack.isEmpty()) {
            Pair cur = stack.removeLast();
            visited[cur.x()][cur.y()] = true;

            for (Pair diff : dirs.get(grid[cur.x()][cur.y()])) {
                int x = cur.x() + diff.x();
                int y = cur.y() + diff.y();
                // 範囲外ならNG
                if (!(0 <= x && x < h && 0 <= y && y < w)) {
                    continue;
                }
                // 訪問済みならNG
                if (visited[x][y]) {
                    continue;
                }

                // つながっているなら移動OK
                int x1 = x + dirs.get(grid[x][y]).get(0).x();
                int y1 = y + dirs.get(grid[x][y]).get(0).y();
                int x2 = x + dirs.get(grid[x][y]).get(1).x();
                int y2 = y + dirs.get(grid[x][y]).get(1).y();
                if ((cur.x() == x1 && cur.y() == y1) || (cur.x() == x2 && cur.y() == y2)) {
                    stack.addLast(new Pair(x, y));
                }
            }
        }


        return visited[h - 1][w - 1];
    }


}

record Pair(int x, int y) {

}
