package find_minimum_time_to_reach_last_room_i;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  public int minTimeToReach(int[][] moveTime) {
    int h = moveTime.length;
    int w = moveTime[0].length;

    int[][] visited = new int[h][w];
    for (int[] row : visited) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    visited[0][0] = 0;

    PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparing(Tuple::t));
    pq.add(new Tuple(0, 0, 0));
    while (pq.poll() instanceof Tuple(int x, int y, int t)) {
      if (visited[x][y] < t) {
        continue;
      }

      for (int[] d : new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
        int nx = d[0] + x;
        int ny = d[1] + y;
        if (!(0 <= nx && nx < h && 0 <= ny && ny < w)) {
          continue;
        }

        int nt = Math.max(t + 1, moveTime[nx][ny] + 1);
        if (nt < visited[nx][ny]) {
          visited[nx][ny] = nt;
          pq.add(new Tuple(nx, ny, nt));
        }
      }
    }

    return visited[h - 1][w - 1];
  }

  private record Tuple(int x, int y, int t) {

  }
}
