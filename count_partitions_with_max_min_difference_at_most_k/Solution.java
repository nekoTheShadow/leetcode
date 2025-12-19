package count_partitions_with_max_min_difference_at_most_k;

import java.util.TreeMap;

public class Solution {
    private static final int MOD = (int) (1e9 + 7);

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int left = 1;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int right = 1; right <= n; right++) {
            tm.merge(nums[right - 1], 1, Integer::sum);
            while (tm.lastKey() - tm.firstKey() > k) {
                remove(tm, nums[left - 1]);
                left++;
            }
            if (left >= 2) {
                dp[right] = (prefixSum[right - 1] - prefixSum[left - 2] + MOD) % MOD;
            } else {
                dp[right] = prefixSum[right - 1] % MOD;
            }
            prefixSum[right] = (prefixSum[right - 1] + dp[right]) % MOD;
        }

        return dp[n];
    }

    private void remove(TreeMap<Integer, Integer> tm, int v) {
        if (tm.get(v) == 1) {
            tm.remove(v);
        } else {
            tm.put(v, tm.get(v) - 1);
        }
    }
}


class Test {
    void main() {
        IO.println(new Solution().countPartitions(new int[]{9, 4, 1, 3, 7}, 4));
        IO.println(new Solution().countPartitions(new int[]{3, 3, 4}, 0));
    }
}
