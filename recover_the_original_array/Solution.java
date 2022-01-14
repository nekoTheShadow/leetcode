package recover_the_original_array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public int[] recoverArray(int[] nums) {
        int n = nums.length/2;
        Map<Integer, Long> d = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int[] ans = new int[n];
        
        for (int num : nums) {
            if ((nums[0]+num)%2!=0) continue;
            int k = Math.abs(nums[0] - (nums[0]+num)/2);
            if (k==0) continue;
           
            TreeMap<Integer, Long> t = new TreeMap<>(d);
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                int x = t.firstKey();
                int y = x + 2*k;
                if (!t.containsKey(y)) {
                    ok = false;
                    break;
                }
                
                ans[i] = (x+y)/2;
                t.put(x, t.get(x)-1);
                t.put(y, t.get(y)-1);
                if (t.get(x)==0) t.remove(x);
                if (t.get(y)==0) t.remove(y);
            }
            
            if (ok) {
                break;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.recoverArray(new int[] {2,10,6,4,8,12})));
        System.out.println(Arrays.toString(sol.recoverArray(new int[] {1,1,3,3})));
        System.out.println(Arrays.toString(sol.recoverArray(new int[] {5,435})));
    }
}
