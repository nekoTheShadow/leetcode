package maximum_number_of_operations_to_move_ones_to_the_end;

public class Solution {
    public int maxOperations(String s) {
        char[] t = s.toCharArray();
        int n = t.length;

        int zero = 0;
        int total = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (t[i] == '0' && (i == n - 1 || t[i + 1] == '1')) {
                zero++;
            }
            if (t[i] == '1') {
                total += zero;
            }
        }
        return total;
    }
}
