package count_good_numbers;

public class Solution {
  public int countGoodNumbers(long n) {
    long mod = (long) 1e9 + 7;
    return (int) ((pow(5, (n + 1) / 2, mod) * pow(4, n / 2, mod)) % mod);
  }

  private long pow(long x, long y, long mod) {
    if (y == 0) {
      return 1;
    }

    if (y % 2 == 0) {
      return pow((x * x) % mod, y / 2, mod);
    } else {
      return (pow(x, y - 1, mod) * x) % mod;
    }
  }
}
