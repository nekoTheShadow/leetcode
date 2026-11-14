package minimum_cost_to_acquire_required_items;

public class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // 戦略1：商品1と商品2をばらばらに買う
        long s1 = (long) cost1 * need1 + (long) cost2 * need2;

        // 戦略2：可能な限り両方買いをした後、残りはばらばらで買う
        long min = Math.min(need1, need2);
        long s2 = costBoth * min + cost1 * (need1 - min) + cost2 * (need2 - min);

        // 戦略3：オーバーを気にせず、両方買いをする
        long max = Math.max(need1, need2);
        long s3 = costBoth * max;

        return Math.min(s1, Math.min(s2, s3));
    }
}
