package _132_pattern;

import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.find132pattern(new int[] {1,2,3,4}));
        System.out.println(sol.find132pattern(new int[] {3,1,4,2}));
        System.out.println(sol.find132pattern(new int[] {-1,3,2,0}));
        System.out.println(sol.find132pattern(new int[] {1,4,0,-1,-2,-3,-1,-2}));
    }

    
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> b = new TreeMap<>();
        for (int i = 2; i < n; i++) {
            b.put(nums[i], b.getOrDefault(nums[i], 0)+1);
        }
        
        int p = nums[0];
        for (int i = 1; i < n-1; i++) {
            int q = nums[i];
            Integer r = b.lowerKey(q);
            
            if (r!=null && p < r && r < q) {
                return true;
            }
            
            p = Math.min(p, q);
            b.put(nums[i+1], b.get(nums[i+1])-1);
            if (b.get(nums[i+1]) == 0) {
                b.remove(nums[i+1]);
            }
        }
        
        return false;
    }
}
