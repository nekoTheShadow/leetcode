package maximum_frequency_of_an_element_after_performing_operations_i;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int ret = 0;
        for (int target = 1; target <= 100000; target++) {
            int l = bisectLeft(nums, target - k);
            int r = bisectLeft(nums, target + k + 1);
            int v = Math.min(numOperations, r - l - freq.getOrDefault(target, 0)) + freq.getOrDefault(target, 0);
            ret = Math.max(ret, v);
        }
        return ret;
    }

    public int bisectLeft(int[] a, int x) {
        int ng = -1;
        int ok = a.length;
        while (Math.abs(ok - ng) > 1) {
            int mi = (ok + ng) / 2;
            if (a[mi] >= x) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }
}
