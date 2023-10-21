package onstrained_subsequence_sum;

import java.util.Arrays;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    System.out.println(new Main().constrainedSubsetSum(new int[] {10, 2, -10, 5, 20}, 2));
    System.out.println(new Main().constrainedSubsetSum(new int[] {-1, -2, -3}, 2));
    System.out.println(new Main().constrainedSubsetSum(new int[] {10, -2, -10, -5, 20}, 2));
  }

  public int constrainedSubsetSum(int[] nums, int k) {
    int n = nums.length;
    int[] dp = new int[n];
    TreeMap<Integer, Integer> t = new TreeMap<>();

    for (int i = 0; i < n; i++) {
      int max = t.isEmpty() ? 0 : Math.max(t.lastKey(), 0);
      dp[i] = nums[i] + max;
      t.put(dp[i], t.getOrDefault(dp[i], 0) + 1);

      if (i - k >= 0) {
        t.put(dp[i - k], t.get(dp[i - k]) - 1);
        if (t.get(dp[i - k]) == 0) {
          t.remove(dp[i - k]);
        }
      }

    }

    return Arrays.stream(dp).max().getAsInt();
  }
}
