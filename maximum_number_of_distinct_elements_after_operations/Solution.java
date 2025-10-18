package maximum_number_of_distinct_elements_after_operations;

import java.util.Arrays;

public class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);

        int c = 0;
        int pre = Integer.MIN_VALUE;
        for (int num : nums) {
            int cur = Math.max(num - k, pre + 1);
            if (cur <= num + k) {
                c++;
                pre = cur;
            }
        }
        return c;
    }
}
