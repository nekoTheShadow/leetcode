package minimum_moves_to_equal_array_elements;

import java.util.Arrays;

public class Solution {
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        return Arrays.stream(nums).map(num -> num - min).sum();
    }
}
