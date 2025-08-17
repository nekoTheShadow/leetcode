package ways_to_express_an_integer_as_sum_of_powers;

public class Solution {
  public int numberOfWays(int n, int x) {
    int mod = pow(10, 9) + 7;
    
    int m = 1;
    while (pow(m, x) <= n) {
      m++;
    }

    int[][] dp = new int[m + 1][n + 1];
    dp[1][0] = 1;

    for (int a = 1; a < m; a++) {
      for (int tot = 0; tot <= n; tot++) {
        // aを採用しない
        dp[a + 1][tot] += dp[a][tot];
        dp[a + 1][tot] %= mod;

        // aを採用する
        if (tot + pow(a, x) <= n) {
          dp[a + 1][tot + pow(a, x)] += dp[a][tot];
          dp[a + 1][tot + pow(a, x)] %= mod;
        }
      }
    }

    return dp[m][n];
  }

  private int pow(int x, int y) {
    if (y == 0) {
      return 1;
    }

    if (y % 2 == 0) {
      return pow(x * x, y / 2);
    } else {
      return x * pow(x, y - 1);
    }
  }
}
