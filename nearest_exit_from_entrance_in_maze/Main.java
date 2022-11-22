package nearest_exit_from_entrance_in_maze;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.nearestExit(new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}}, new int[]{1, 2}));
        System.out.println(m.nearestExit(new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}}, new int[]{1, 0}));
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int h = maze.length;
        int w = maze[0].length;
        int[][] score = new int[h][w];
        for (int[] row : score) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        score[entrance[0]][entrance[1]] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        q.add(new int[] {0, entrance[0], entrance[1]});
        while (!q.isEmpty()) {
            int[] t = q.remove();
            int cost = t[0];
            int x = t[1];
            int y = t[2];
            if (score[x][y] < cost) continue;

            for (int[] diff : new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                int nx = x + diff[0];
                int ny = y + diff[1];
                if (0<=nx&&nx<h&&0<=ny&&ny<w && maze[nx][ny]=='.' && cost +1<score[nx][ny]) {
                    score[nx][ny] = cost + 1;
                    q.add(new int[] {cost+1, nx, ny});
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((i==0 || i==h-1 || j==0 || j==w-1) && !(i==entrance[0] && j==entrance[1]) && maze[i][j]=='.') {
                    min = Math.min(min, score[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
