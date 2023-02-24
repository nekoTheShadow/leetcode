package minimize_deviation_in_array;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = Arrays.stream(nums)
                                     .map(num -> num%2==0 ? num : num*2)
                                     .boxed()
                                     .collect(Collectors.toCollection(TreeSet::new));
        int ans = Integer.MAX_VALUE;
        while (true) {
            Integer v = set.last();
            ans = Math.min(ans, v - set.first());
            
            if (v%2==0) {
                set.remove(v);
                set.add(v/2);
            } else {
                break;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minimumDeviation(new int[] {1,2,3,4}));
        System.out.println(new Solution().minimumDeviation(new int[] {4,1,5,20,3}));
        System.out.println(new Solution().minimumDeviation(new int[] {2,10,8}));
    }
}
