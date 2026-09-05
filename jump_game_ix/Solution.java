package jump_game_ix;

public class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        int[] ans = new int[n];
        int i = 0;
        while (i < n) {
            int start = i;
            while (i < n - 1 && prefixMax[i] > suffixMin[i + 1]) {
                i++;
            }
            int end = i;

            int currentMax = 0;
            for (int x = start; x <= end; x++) {
                currentMax = Math.max(currentMax, nums[x]);
            }

            for (int x = start; x <= end; x++) {
                ans[x] = currentMax;
            }

            i++;
        }
        return ans;
    }
}
