package find_numbers_with_even_number_of_digits;

import java.util.Arrays;

public class Solution {
  public int findNumbers(int[] nums) {
    return (int) Arrays.stream(nums).filter(num -> length(num) % 2 == 0).count();
  }

  private int length(int num) {
    return (int) Math.log10((double) num) + 1;
  }
}
