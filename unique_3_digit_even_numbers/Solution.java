package unique_3_digit_even_numbers;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> evens = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || j == k || k == i || digits[i] == 0) {
                        continue;
                    }
                    int v = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (v % 2 == 0) {
                        evens.add(v);
                    }
                }
            }
        }
        return evens.size();
    }
}