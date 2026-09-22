package find_two_non_overlapping_sub_arrays_each_with_target_sum;

import java.util.Arrays;

public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] mins = new int[n];
        Arrays.fill(mins, Integer.MAX_VALUE);

        int left = 0;
        int total = 0;
        int ans = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            total += arr[right];
            while (total > target) {
                total -= arr[left];
                left += 1;
            }

            if (total == target) {
                int length = right - left + 1;
                if (left > 0 && mins[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, length + mins[left - 1]);
                }
                min = Math.min(min, length);
            }
            mins[right] = min;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
