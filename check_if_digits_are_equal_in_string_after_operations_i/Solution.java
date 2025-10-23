package check_if_digits_are_equal_in_string_after_operations_i;

public class Solution {
    public boolean hasSameDigits(String s) {
        int len = s.length();
        if (len == 2) {
            return s.charAt(0) == s.charAt(1);
        }

        StringBuilder t = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            int a = s.charAt(i) - '0';
            int b = s.charAt(i + 1) - '0';
            t.append((a + b) % 10);
        }
        return hasSameDigits(t.toString());
    }
}