package minimum_positive_sum_subarray;

import java.util.List;
import java.util.TreeMap;

public class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        TreeMap<Long, Integer> map = new TreeMap<>();

        long ans = Long.MAX_VALUE;

        for (int i = l; i <= n; i++) {
            // j = i - l を追加
            long add = prefix[i - l];
            map.merge(add, 1, Integer::sum);

            // j = i - r - 1 を削除
            int removeIndex = i - r - 1;
            if (removeIndex >= 0) {
                long remove = prefix[removeIndex];
                map.compute(remove, (k, v) -> v == 1 ? null : v - 1);
            }

            // prefix[j] < prefix[i] の最大値を取得
            Long key = map.lowerKey(prefix[i]);

            if (key != null) {
                ans = Math.min(ans, prefix[i] - key);
            }
        }

        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}