package maximum_frequency_of_an_element_after_performing_operations_ii;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, Integer> imos = new TreeMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
            imos.merge(num, 0, Integer::sum);
            imos.merge(num - k, 1, Integer::sum);
            imos.merge(num + k + 1, -1, Integer::sum);
        }

        int max = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> e : imos.entrySet()) {
            sum += e.getValue();
            max = Math.max(max, Math.min(sum, freq.getOrDefault(e.getKey(), 0) + numOperations));
        }
        return max;
    }
}
