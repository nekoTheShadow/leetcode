package minimum_equal_sum_of_two_arrays_after_replacing_zeros;

import java.util.Arrays;

public class Solution {
  // 1. 両方0あり : 特殊合計の大きい方が答え
  // 2. 片方0あり :
  // - 0ありの特殊合計 <= 0なしの特殊合計 → 0なし特殊合計が答え
  // - それ以外の場合 → -1
  // 3. 両方0なし
  // - 特殊合計が一致するなら、その値が答え。
  // - それ以外は-1

  public long minSum(int[] nums1, int[] nums2) {
    boolean zero1 = hasZero(nums1);
    boolean zero2 = hasZero(nums2);
    long sum1 = specialSum(nums1);
    long sum2 = specialSum(nums2);

    if (zero1 && zero2) {
      return Math.max(sum1, sum2);
    } else if (zero1 && !zero2) {
      return sum1 <= sum2 ? sum2 : -1;
    } else if (!zero1 && zero2) {
      return sum1 >= sum2 ? sum1 : -1;
    } else {
      return sum1 == sum2 ? sum1 : -1;
    }
  }

  private boolean hasZero(int[] nums) {
    return Arrays.stream(nums).anyMatch(num -> num == 0);
  }

  private long specialSum(int[] nums) {
    return Arrays.stream(nums).mapToLong(num -> num == 0 ? 1 : num).sum();
  }
}
