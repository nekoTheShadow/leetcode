package count_subarrays_with_score_less_than_k;

public class Solution {
  public long countSubarrays(int[] nums, long k) {
    int n = nums.length;
    int right = 0;
    long sum = 0;
    long ret = 0;

    for (int left = 0; left < n; left++) {
      while (right < n && (sum + nums[right]) * (right - left + 1) < k) {
        sum += nums[right];
        right++;
      }
      ret += right - left;
      if (left == right) {
        right++;
      } else {
        sum -= nums[left];
      }
    }
    return ret;
  }
}
