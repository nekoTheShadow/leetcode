package total_characters_in_string_after_transformations_ii;

import java.util.List;

public class Solution {
  public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
    long[][] transition = new long[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < nums.get(i); j++) {
        transition[i][(i + j + 1) % 26]++;
      }
    }
    transition = matPow(transition, t);
    
    long[] count = new long[N];
    for (char ch : s.toCharArray()) {
      count[ch - 'a']++;
    }
    
    long[] ret = new long[N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        ret[j] += transition[i][j] * count[i] % MOD;
        ret[j] %= MOD;
      }
    }
    
    long total = 0;
    for (long v : ret) {
      total += v;
      total %= MOD;
    }
    return (int)total;
  }
  
  
  private static long MOD = 1_000_000_000 + 7;
  
  private static int N = 26;
  
  private long[][] matMul(long[][] a, long[][] b) {
    long[][] c = new long[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          c[i][j] += a[i][k] * b[k][j] % MOD;
          c[i][j] %= MOD;
        }
      }
    }
    return c;
  }
  
  private long[][] matPow(long[][] a, long k) {
    if (k == 0) {
      long[][] b = new long[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          b[i][j] = (i == j) ? 1 : 0;
        }
      }
      return b;
    }
    
    if (k % 2 == 0) {
      return matPow(matMul(a, a), k / 2);
    } else {
      return matMul(a, matPow(a, k - 1));
    }
  }
}
