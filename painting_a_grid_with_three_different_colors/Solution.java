package painting_a_grid_with_three_different_colors;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
  private static int MOD = 1_000_000_000 + 7;

  private static String[] COLORS = new String[] {"R", "G", "B"};

  public int colorTheGrid(int m, int n) {
    String[] patterns = makePatterns(m);

    int l = patterns.length;
    int[][] dp = new int[n][l];
    Arrays.fill(dp[0], 1);
    for (int x = 0; x < n - 1; x++) {
      for (int i = 0; i < l; i++) {
        for (int j = 0; j < l; j++) {
          if (isOK(m, patterns[i], patterns[j])) {
            dp[x + 1][j] += dp[x][i];
            dp[x + 1][j] %= MOD;
          }
        }
      }
    }

    int total = 0;
    for (int v : dp[n - 1]) {
      total += v;
      total %= MOD;
    }
    return total;
  }


  private String[] makePatterns(int m) {
    List<String> patterns = new ArrayList<>();
    Deque<String> stack = new ArrayDeque<>();
    for (String color : COLORS) {
      stack.offerLast(color);
    }

    while (stack.pollLast() instanceof String pattern) {
      if (pattern.length() == m) {
        patterns.add(pattern);
      } else {
        for (String color : COLORS) {
          if (!pattern.endsWith(color)) {
            stack.offerLast(pattern + color);
          }
        }
      }
    }

    return patterns.toArray(String[]::new);
  }

  private boolean isOK(int m, String pattern1, String pattern2) {
    return IntStream.range(0, m).allMatch(i -> pattern1.charAt(i) != pattern2.charAt(i));
  }
}
