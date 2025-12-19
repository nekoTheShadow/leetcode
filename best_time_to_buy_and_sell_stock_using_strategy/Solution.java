package best_time_to_buy_and_sell_stock_using_strategy;

import java.util.stream.IntStream;

public class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long max = IntStream.range(0, n).mapToLong(i -> (long) prices[i] * strategy[i]).sum();

        long total = max;
        for (int i = 0; i < k / 2; i++) {
            total += delta(prices[i], strategy[i], 0);
        }
        for (int i = k / 2; i < k; i++) {
            total += delta(prices[i], strategy[i], 1);
        }

        max = Math.max(max, total);

        for (int i = 1; i <= n - k; i++) {
            total += delta(prices[i - 1], 0, strategy[i - 1]);
            total += delta(prices[i + k / 2 - 1], 1, 0);
            total += delta(prices[i + k - 1], strategy[i + k - 1], 1);
            max = Math.max(max, total);
        }

        return max;
    }

    private long delta(int price, int from, int to) {
        return (long) price * (to - from);
    }
}


class Test {
    void main() {
        Solution s = new Solution();
        IO.println(s.maxProfit(new int[]{4, 2, 8}, new int[]{-1, 0, 1}, 2));
        IO.println(s.maxProfit(new int[]{5, 4, 3}, new int[]{1, 1, 0}, 2));
    }
}
