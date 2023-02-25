package best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int max = 0;
        for (int i = 1, len = prices.length; i < len; i++) {
            max = Math.max(max, prices[i]-buy);
            buy = Math.min(buy, prices[i]);
        }
        return max;
    }
}
