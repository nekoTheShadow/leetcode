package next_greater_numerically_balanced_number;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int nextBeautifulNumber(int n) {
        int x = n + 1;
        while (!isBeautiful(x)) {
            x++;
        }
        return x;
    }

    private boolean isBeautiful(int x) {
        Map<Integer, Integer> freq = new HashMap<>();
        while (x > 0) {
            freq.merge(x % 10, 1, Integer::sum);
            x /= 10;
        }
        return freq.entrySet().stream().allMatch(e -> e.getKey().equals(e.getValue()));
    }
}
