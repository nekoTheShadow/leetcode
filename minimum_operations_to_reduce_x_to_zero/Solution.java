package minimum_operations_to_reduce_x_to_zero;

import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int target = Arrays.stream(nums).sum()-x;
        
        int right = 0;
        int sum = 0;
        int len = -1;
        for (int left = 0; left < n; left++) {
            while (right < n && sum + nums[right] <= target) {
                sum += nums[right];
                right++;
            }
            
            if (sum == target) {
                len = Math.max(len, right-left);
            }
            
            if (right == left) {
                right++;
            } else {
                sum -= nums[left];
            }
        }
        
        return len==-1 ? -1 : nums.length-len;
    }
}
