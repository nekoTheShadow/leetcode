package smallest_missing_non_negative_integer_after_operations;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> seq = new HashMap<>();
        for (int num : nums) {
            int mod = num % value;
            if (mod < 0) {
                mod += value;
            }

            seq.put(mod, seq.getOrDefault(mod, 0) + 1);
        }
        int k = 0;
        while (true) {
            int mod = k % value;
            if (!seq.containsKey(mod) || seq.get(mod) == 0) {
                break;
            }

            seq.put(mod, seq.get(mod) - 1);
            k++;
        }
        return k;
    }
}