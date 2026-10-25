package maximum_k_to_sort_a_permutation;

import java.util.stream.IntStream;

public class Solution {
    public int sortPermutation(int[] nums) {
        return IntStream.range(0, nums.length).filter(i -> nums[i] != i).reduce((acc, x) -> acc & x).orElse(0);
    }
}
