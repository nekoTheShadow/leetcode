package count_commas_in_range;

public class Solution {
    public int countCommas(int n) {
        return n < 1000 ? 0 : (n - 1000 + 1);
    }
}
