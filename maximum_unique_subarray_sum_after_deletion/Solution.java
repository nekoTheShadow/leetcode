package maximum_unique_subarray_sum_after_deletion;

import java.util.Arrays;

public class Solution {
  public int maxSum(int[] nums) {
    // numsの中に自然数がひとつでもあれば、自然数の和が答え (重複をのぞく)。
    // numsの中に自然数がひとつもない、つまり、すべて負の数の場合、もっとも大きい負の数が答え。
    if (Arrays.stream(nums).anyMatch(num -> num >= 0)) {
      return Arrays.stream(nums).filter(num -> num >= 0).distinct().sum();
    } else {
      return Arrays.stream(nums).max().getAsInt();
    }
  }
}
