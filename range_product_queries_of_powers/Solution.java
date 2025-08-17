package range_product_queries_of_powers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public int[] productQueries(int n, int[][] queries) {
    long mod = 1_000_000_000 + 7;
    long[] powers = powers(n);
    int m = powers.length;

    long[] a = new long[m + 1];
    a[0] = 1;
    for (int i = 0; i < m; i++) {
      a[i + 1] = a[i] * powers[i];
      a[i + 1] %= mod;
    }

    return Arrays.stream(queries).mapToInt(query -> {
      int l = query[0];
      int r = query[1];
      long v = (a[r + 1] * inverse(a[l], mod)) % mod;
      return (int) v;
    }).toArray();
  }

  private long[] powers(long n) {
    List<Long> powers = new ArrayList<>();
    long power = 1;
    while (n > 0) {
      if (n % 2 == 1) {
        powers.add(power);
      }
      power *= 2;
      n /= 2;
    }
    return powers.stream().mapToLong(Long::longValue).toArray();
  }

  private long inverse(long v, long mod) {
    return BigInteger.valueOf(v).modInverse(BigInteger.valueOf(mod)).intValue();
  }
}
