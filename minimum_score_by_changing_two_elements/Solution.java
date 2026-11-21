package minimum_score_by_changing_two_elements;

import java.util.Arrays;

public class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max1 = nums[n - 1] - nums[2]; // 小さいほうから2つ変更 → 最大値=1番目に大きい値 最小値=3番目に小さい値
        int max2 = nums[n - 3] - nums[0]; // 大きいほうから2つ変更 → 最大値=3番目に大きい値 最小値=1番目に小さい値
        int max3 = nums[n - 2] - nums[1]; // 小さいほうと大きいほうを変更 → 最大値=2番目に大きい値 最小値=2番目に小さい値
        return Math.min(Math.min(max1, max2), max3);
    }
}
