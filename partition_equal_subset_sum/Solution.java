package partition_equal_subset_sum;

import java.util.Arrays;

public class Solution {
  public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 != 0) {
      return false;
    }

    int m = nums.length;
    int n = sum / 2;
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j <= n; j++) {
        if (dp[i][j] && j + nums[i] <= n) {
          dp[i + 1][j + nums[i]] = true;
        }
        if (dp[i][j]) {
          dp[i + 1][j] = true;
        }
      }
    }

    return dp[m][n];
  }
}
