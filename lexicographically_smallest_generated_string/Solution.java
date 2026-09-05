package lexicographically_smallest_generated_string;

import java.util.Arrays;

public class Solution {
    public String generateString(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        char[] s = new char[n1 + n2 - 1];
        boolean[] fixed = new boolean[n1 + n2 - 1];
        Arrays.fill(s, 'a');

        for (int i = 0; i < n1; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < n2; j++) {
                    if (fixed[i + j] && s[i + j] != str2.charAt(j)) {
                        return "";
                    }
                    s[i + j] = str2.charAt(j);
                    fixed[i + j] = true;
                }
            }
        }

        for (int i = 0; i < n1; i++) {
            if (str1.charAt(i) == 'F') {
                if (allMatch(s, str2, i)) {
                    int index = lastIndex(fixed, i, n2);
                    if (index == -1) {
                        return "";
                    }
                    s[index] = 'b';
                }
            }
        }

        return new String(s);
    }

    private boolean allMatch(char[] s, String str2, int start) {
        for (int i = 0; i < str2.length(); i++) {
            if (s[start + i] != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private int lastIndex(boolean[] fixed, int start, int m) {
        for (int i = start + m - 1; i >= start; i--) {
            if (!fixed[i]) {
                return i;
            }
        }
        return -1;
    }
}
