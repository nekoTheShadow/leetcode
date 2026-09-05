package sum_of_distances;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> ht = IntStream.range(0, nums.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> nums[i]));

        long[] ret = new long[nums.length];
        for (List<Integer> indexes : ht.values()) {
            long left = 0;
            long right = indexes.stream().mapToLong(Long::valueOf).sum();
            int n = indexes.size();
            for (int i = 0; i < n; i++) {
                int x = indexes.get(i);
                ret[x] = right - left + (2L * i - n) * x;
                left += x;
                right -= x;
            }
        }

        return ret;
    }
}
