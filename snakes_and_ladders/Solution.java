package snakes_and_ladders;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  private static int INF = Integer.MAX_VALUE / 2 - 1;

  public int snakesAndLadders(int[][] board) {
    int n = board.length;
    int[] jump = toJump(n, board);

    int[] cost = new int[n * n];
    Arrays.fill(cost, INF);
    cost[0] = 0;

    PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparing(Tuple::cost));
    pq.add(new Tuple(0, 0));
    while (pq.poll() instanceof Tuple(int cur, int c)) {
      if (cost[cur] < c) {
        continue;
      }

      for (int diff = 1; diff <= 6; diff++) {
        int nxt = cur + diff;
        if (nxt >= n * n) {
          break;
        }
        if (jump[nxt] != -1) {
          nxt = jump[nxt];
        }
        if (cost[cur] + 1 < cost[nxt]) {
          cost[nxt] = cost[cur] + 1;
          pq.add(new Tuple(nxt, cost[nxt]));
        }
      }
    }

    return cost[n * n - 1] == INF ? -1 : cost[n * n - 1];
  }

  private int[] toJump(int n, int[][] board) {
    int[] jump = new int[n * n];
    int x = 0;
    boolean rev = false;
    for (int i = n - 1; i >= 0; i--) {
      if (rev) {
        for (int j = n - 1; j >= 0; j--) {
          jump[x++] = board[i][j] == -1 ? -1 : board[i][j] - 1;
        }
      } else {
        for (int j = 0; j < n; j++) {
          jump[x++] = board[i][j] == -1 ? -1 : board[i][j] - 1;
        }
      }
      rev = !rev;
    }
    return jump;
  }

  private record Tuple(int cur, int cost) {

  }
}
