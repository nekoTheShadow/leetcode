package minimum_operations_to_sort_a_string;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int minOperations(String s) {
        // すでにソート済み
        if (check(s.toCharArray())) {
            return 0;
        }

        // 2文字の場合はNG
        if (s.length() == 2) {
            return -1;
        }

        return Math.min(f1(s), f2(s));
    }

    private int f1(String s) {
        char[] c = s.toCharArray();
        sort1(c);
        if (check(c)) {
            return 1;
        }

        sort2(c);
        return check(c) ? 2 : 3;
    }

    private int f2(String s) {
        char[] c = s.toCharArray();
        sort2(c);
        if (check(c)) {
            return 1;
        }

        sort1(c);
        return check(c) ? 2 : 3;
    }


    private void sort1(char[] c) {
        Arrays.sort(c, 0, c.length - 1);
    }

    private void sort2(char[] c) {
        Arrays.sort(c, 1, c.length);
    }

    private boolean check(char[] c) {
        return IntStream.range(0, c.length - 1).allMatch(i -> c[i] <= c[i + 1]);
    }
}
