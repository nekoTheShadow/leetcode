package find_x_sum_of_all_k_long_subarrays_i;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        Comparator<Map.Entry<Integer, Long>> comparator =
                Map.Entry.<Integer, Long>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey())
                        .reversed();


        int len = nums.length;
        int[] ans = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) {
            Map<Integer, Long> freq = IntStream.range(i, i + k)
                    .mapToObj(j -> nums[j])
                    .collect(groupingBy(Function.identity(), counting()));

            int total = freq.entrySet()
                    .stream()
                    .sorted(comparator)
                    .limit(x)
                    .mapToInt(e -> e.getKey() * e.getValue().intValue())
                    .sum();
            ans[i] = total;
        }
        return ans;
    }
}