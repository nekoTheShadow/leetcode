package maximum_erasure_value;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumUniqueSubarray(new int[] {4,2,4,5,6}));
        System.out.println(new Solution().maximumUniqueSubarray(new int[] {5,2,1,2,5,2,1,2,5}));
    }
    
    public int maximumUniqueSubarray(int[] nums) {
        int right = 0;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int ans = -1;
        int sum = 0;
        for (int left = 0; left < n; left++) {
            while (right < n && !set.contains(nums[right])) {
                set.add(nums[right]);
                sum += nums[right];
                right++;
            }
            
            ans = Math.max(sum, ans);
            
            if (right == left) {
                right++;
            } else {
                set.remove(nums[left]);
                sum -= nums[left];
            }
        }
        
        return ans;
    }
}
