package count_the_number_of_good_subarrays;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public long countGood(int[] nums, int k) {
    Map<Integer, Integer> d = new HashMap<>();
    int pair = 0;
    long ret = 0;

    int n = nums.length;
    int left = 0;
    for (int right = 0; right < n; right++) {
      pair += d.getOrDefault(nums[right], 0);
      d.put(nums[right], d.getOrDefault(nums[right], 0) + 1);

      while (pair >= k) {
        ret += n - right;
        d.put(nums[left], d.get(nums[left]) - 1);
        pair -= d.get(nums[left]);
        left += 1;
      }
    }

    return ret;
  }
}
