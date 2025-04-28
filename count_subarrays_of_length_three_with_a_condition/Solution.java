package count_subarrays_of_length_three_with_a_condition;

import java.util.stream.IntStream;

public class Solution {
  public int countSubarrays(int[] nums) {
    return (int) IntStream.range(0, nums.length - 2)
        .filter(i -> (nums[i] + nums[i + 2]) * 2 == nums[i + 1]).count();
  }
}
