package count_complete_subarrays_in_an_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int countCompleteSubarrays(int[] nums) {
    long d = Arrays.stream(nums).distinct().count();
    int n = nums.length;
    int left = 0;
    Map<Integer, Integer> h = new HashMap<Integer, Integer>();
    int ret = 0;
    for (int right = 0; right < n; right++) {
      plus(h, nums[right], 1);
      while (h.size() == d) {
        ret += n - right;
        plus(h, nums[left], -1);
        left++;
      }
    }
    return ret;
  }

  private void plus(Map<Integer, Integer> h, int k, int v) {
    h.put(k, h.getOrDefault(k, 0) + v);
    if (h.get(k) == 0) {
      h.remove(k);
    }
  }
}
