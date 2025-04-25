package count_of_interesting_subarrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
    int n = nums.size();

    int[] d = new int[n + 1];
    for (int i = 0; i < n; i++) {
      d[i + 1] = d[i] + (nums.get(i) % modulo == k ? 1 : 0);
    }

    long ret = 0;
    Map<Integer, Long> h = new HashMap<>();
    for (int i = 0; i <= n; i++) {
      ret += h.getOrDefault(((d[i] % modulo) - k + modulo) % modulo, 0L);
      h.put(d[i] % modulo, h.getOrDefault(d[i] % modulo, 0L) + 1);
    }
    return ret;
  }
}