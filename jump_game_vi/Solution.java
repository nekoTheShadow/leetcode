package jump_game_vi;

import java.util.TreeMap;

public class Solution {
    public int maxResult(int[] nums, int k) {
        TreeMap<Integer, Integer> t = new TreeMap<>();
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        t.put(nums[0], 1); // [i-k, i-1]

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + t.lastKey();
            if (i-k >= 0) {
                t.put(dp[i-k], t.get(dp[i-k])-1);
                if (t.get(dp[i-k]) == 0) {
                    t.remove(dp[i-k]);
                }
            }
            t.put(dp[i], t.getOrDefault(dp[i], 0)+1);
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxResult(new int[] {1,-1,-2,4,-7,3}, 2));
        System.out.println(new Solution().maxResult(new int[] {10,-5,-2,4,0,3}, 3));
        System.out.println(new Solution().maxResult(new int[] {1,-5,-20,4,-1,3,-6,-3}, 2));
    }
}
