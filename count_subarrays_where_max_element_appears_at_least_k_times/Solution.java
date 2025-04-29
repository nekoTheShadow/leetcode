package count_subarrays_where_max_element_appears_at_least_k_times;

import java.util.Arrays;

public class Solution {
  public long countSubarrays(int[] nums, int k) {
    int max = Arrays.stream(nums).max().getAsInt();
    int n = nums.length;
    int left = 0;
    int count = 0;
    long ret = 0;
    for (int right = 0; right < n; right++) {
      if (nums[right] == max) {
        count++;
      }

      while (k <= count) {
        ret += n - right;
        if (nums[left] == max) {
          count--;
        }
        left++;
      }
    }
    return ret;
  }
}
