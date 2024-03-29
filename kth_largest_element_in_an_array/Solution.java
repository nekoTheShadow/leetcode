package kth_largest_element_in_an_array;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[] {3,2,1,5,6,4}, 2));
        System.out.println(new Solution().findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }
    
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }


}
