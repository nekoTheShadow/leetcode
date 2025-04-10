package count_the_number_of_powerful_integers;

import java.math.BigInteger;

public class Solution {
  public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
    return count(finish, limit, s) - count(start - 1, limit, s);
  }


  public long count(long n, int limit, String s) {
    if (n < Long.parseLong(s)) {
      return 0;
    }

    long ok = -1;
    long ng = n + 1;
    while (Math.abs(ok - ng) > 1) {
      long mi = (ok + ng) / 2;
      if (new BigInteger(BigInteger.valueOf(mi).toString(limit + 1) + s)
          .compareTo(BigInteger.valueOf(n)) <= 0) {
        ok = mi;
      } else {
        ng = mi;
      }
    }
    return ok + 1;
  }


}
