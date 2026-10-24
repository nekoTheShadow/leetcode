package minimum_operations_to_sort_a_permutation;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[] want = IntStream.range(0, n).toArray();
        int i = IntStream.range(0, n).filter(x -> nums[x] == 0).findFirst().getAsInt();

        int[] a1 = IntStream.concat(
                Arrays.stream(Arrays.copyOfRange(nums, i, n)),
                Arrays.stream(Arrays.copyOfRange(nums, 0, i))
        ).toArray();
        if (Arrays.equals(want, a1)) {
            return Math.min(i, n - i + 2);
        }

        int[] a2 = IntStream.concat(
                Arrays.stream(reverse(Arrays.copyOfRange(nums, 0, i + 1))),
                Arrays.stream(reverse(Arrays.copyOfRange(nums, i + 1, n)))
        ).toArray();
        if (Arrays.equals(want, a2)) {
            return Math.min(i + 2, n - i);
        }

        return -1;
    }

    private int[] reverse(int[] a) {
        int n = a.length;
        return IntStream.range(0, a.length).map(i -> a[n - i - 1]).toArray();
    }
}