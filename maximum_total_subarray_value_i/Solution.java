package maximum_total_subarray_value_i;

import java.util.Arrays;

public class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Arrays.stream(nums).max().getAsInt();
        long min = Arrays.stream(nums).min().getAsInt();
        return (max - min) * (long) k;
    }
}
