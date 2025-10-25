package calculate_money_in_leetcode_bank;

public class Solution {
    public int totalMoney(int n) {
        int w = n / 7;
        int d = n % 7;
        return sum(sum(1, 1, 7), 7, w) + sum(w + 1, 1, d);
    }

    // 初項:a 公差:d 項数:n
    private int sum(int a, int d, int n) {
        return n * (a + (a + (n - 1) * d)) / 2;
    }
}
