package count_commas_in_range_ii;

public class Solution {
    public long countCommas(long n) {
        int base = 3;
        long count = 0;
        while (Math.powExact(10L, base) <= n) {
            long limit = Math.powExact(10L, base + 1) - 1;
            count += (Math.min(n, limit) - Math.powExact(10L, base) + 1) * (base / 3);
            base++;
        }
        return count;
    }
}
