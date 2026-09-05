package smallest_missing_integer_greater_than_sequential_prefix_sum;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int missingInteger(int[] nums) {
        int tot = IntStream.range(0, nums.length)
                .takeWhile(i -> i == 0 || nums[i - 1] + 1 == nums[i])
                .map(i -> nums[i])
                .sum();
        return IntStream.iterate(tot, x -> x + 1)
                .filter(x -> Arrays.stream(nums).noneMatch(num -> num == x))
                .findFirst()
                .getAsInt();
    }
}
