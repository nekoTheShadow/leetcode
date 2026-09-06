package smallest_stable_index_i;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        return IntStream.range(0, nums.length).filter(x -> {
            int max = Arrays.stream(nums, 0, x + 1).max().getAsInt();
            int min = Arrays.stream(nums, x, n).min().getAsInt();
            return max - min <= k;
        }).findFirst().orElse(-1);
    }
}