package minimum_moves_to_equal_array_elements_ii;

import java.util.Arrays;

public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int med = nums[nums.length / 2];
        return Arrays.stream(nums).map(num -> Math.abs(num - med)).sum();
    }
}
