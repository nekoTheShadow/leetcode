package count_number_of_balanced_permutations;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  private long MOD = 1_000_000_000 + 7;
  private long[] C;

  private long[] F;
  private long[] G;

  private Map<Key, Long> H;

  public int countBalancedPermutations(String num) {
    int n = num.length();

    C = new long[10];
    for (int i = 0; i < n; i++) {
      C[num.charAt(i) - '0']++;
    }

    F = new long[n + 1];
    G = new long[n + 1];
    F[0] = F[1] = 1;
    G[0] = G[1] = 1;
    for (int i = 2; i <= n; i++) {
      F[i] = F[i - 1] * i % MOD;
      G[i] = BigInteger.valueOf(F[i]).modInverse(BigInteger.valueOf(MOD)).longValue();
    }

    long sum = 0;
    for (int i = 0; i < 10; i++) {
      sum += C[i] * i;
    }

    H = new HashMap<>();

    return (int) dfs(0, sum / 2, sum / 2, (n + 1) / 2, n / 2);
  }



  public long dfs(long i, long sum1, long sum2, long count1, long count2) {
    if (i == 10) {
      if (sum1 == 0 && sum2 == 0 && count1 == 0 && count2 == 0) {
        return 1;
      } else {
        return 0;
      }
    }

    if (sum1 < 0 || sum2 < 0 || count1 < 0 || count2 < 0) {
      return 0;
    }

    Key key = new Key(i, sum1, sum2, count1, count2);
    if (H.containsKey(key)) {
      return H.get(key);
    }

    long ret = 0;
    for (long x1 = 0; x1 <= get(C, i); x1++) {
      long x2 = get(C, i) - x1;

      long t = mul(nCr(count1, x1), nCr(count2, x2),
          dfs(i + 1, sum1 - i * x1, sum2 - i * x2, count1 - x1, count2 - x2));
      ret = (ret + t) % MOD;
    }

    H.put(key, ret);
    return ret;
  }

  private long nCr(long n, long r) {
    if (n < r) {
      return 0;
    }
    return mul(get(F, n), get(G, r), get(G, n - r));
  }

  private long mul(long... nums) {
    long ret = 1;
    for (long num : nums) {
      ret *= num;
      ret %= MOD;
    }
    return ret;
  }

  private long get(long[] a, long i) {
    return a[(int) i];
  }

  private record Key(long i, long sum1, long sum2, long count1, long count2) {
  }
}
