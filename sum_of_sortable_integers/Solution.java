package sum_of_sortable_integers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] target = Arrays.stream(nums).sorted().toArray();
        Set<Integer> divisors = new HashSet<>();
        for (int x = 1; x * x <= n; x++) {
            if (n % x == 0) {
                divisors.add(x);
                divisors.add(n / x);
            }
        }

        int total = 0;
        for (int divisor : divisors) {
            boolean ok = true;
            for (int left = 0; left < n; left += divisor) {
                int[] sub1 = Arrays.copyOfRange(nums, left, left + divisor);
                int[] sub2 = Arrays.copyOfRange(target, left, left + divisor);
                if (!check(sub1, sub2)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                total += divisor;
            }
        }
        return total;
    }

    private boolean check(int[] nums1, int[] nums2) {
        int[] doubled = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums1)).toArray();
        return kmp(doubled, nums2);
    }

    private boolean kmp(int[] text, int[] pattern) {
        int[] lps = new int[pattern.length];

        for (int i = 1, len = 0; i < pattern.length; ) {
            if (pattern[i] == pattern[len]) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        for (int i = 0, j = 0; i < text.length; ) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
                if (j == pattern.length) {
                    return true;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return false;
    }
}