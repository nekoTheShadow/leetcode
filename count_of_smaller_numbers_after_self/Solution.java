package count_of_smaller_numbers_after_self;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countSmaller(new int[] {5,2,6,1}));
        System.out.println(new Solution().countSmaller(new int[] {-1}));
        System.out.println(new Solution().countSmaller(new int[] {-1, -1}));
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = nums.length-1; i >= 0; i--) {
            int x = bisectLeft(a, nums[i]);
            b.add(x);
            a.add(x, nums[i]);
        }
        
        Collections.reverse(b);
        return b;
    }
    
    public <T> int bisectLeft(List<? extends Comparable<? super T>> a, T x) {
        int ng = -1;
        int ok = a.size();
        while (Math.abs(ok-ng) > 1) {
            int mi = (ok+ng)/2;
            if (a.get(mi).compareTo(x) >= 0) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }
}
