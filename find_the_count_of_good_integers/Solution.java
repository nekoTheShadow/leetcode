package find_the_count_of_good_integers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
  public long countGoodIntegers(int n, int k) {
    long start = (long)Math.pow(10, (n - 1) / 2);
    Set<String> set = new HashSet<>();
    for (long x = start; x < start * 10; x++) {
      String l = Long.toString(x);
      String r = new StringBuilder(l).reverse().substring(n % 2);
      String s = l + r;
      if (Long.parseLong(s) % k == 0) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        set.add(new String(t));
      }
    }  
    return set.stream().mapToLong(s -> count(s)).sum();
  }

  private long count(String s) {
    int[] c = new int[10];
    for (char ch : s.toCharArray()) {
      c[ch - '0']++;
    }

    int n = s.length();
    long total = 1;
    for (int i = 0; i < 10; i++) {
      if (i == 0) {
        total *= nCr(n - 1, c[i]);
      } else {
        total *= nCr(n, c[i]);
      }
      n -= c[i];
    }
    return total;
  }


  private long nCr(int n, int r) {
    if (n == r || r == 0) {
      return 1;
    } else {
      return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }
  }
}
