package count_subarrays_with_fixed_bounds;

public class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int idxMin = -1;
        int idxMax = -1;
        int start = 0;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<minK || nums[i]>maxK) {
                idxMin = -1;
                idxMax = -1;
                start = i+1;
            }
            if (nums[i]==minK) {
                idxMin = i;
            }
            if (nums[i]==maxK) {
                idxMax = i;
            }
            if (idxMin!=-1 && idxMax!=-1) {
                ans += Math.min(idxMin, idxMax)-start+1;
            }
            
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countSubarrays(new int[] {1,3,5,2,7,5}, 1, 5));
        System.out.println(new Solution().countSubarrays(new int[] {1,1,1,1}, 1, 1));
    }
}
