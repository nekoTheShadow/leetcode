package minimum_moves_to_equal_array_elements_iii;

import java.util.Arrays;

public class Solution {
    public int minMoves(int[] nums) {
        return Arrays.stream(nums).max().getAsInt() * nums.length - Arrays.stream(nums).sum();
    }
}
