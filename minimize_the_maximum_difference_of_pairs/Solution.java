package minimize_the_maximum_difference_of_pairs;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int ng = -1;
        int ok = nums[nums.length-1]-nums[0]+1;
        while (Math.abs(ok-ng) > 1) {
            int mi = (ok+ng)/2;
            if (count(nums, mi) >= p) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }
    
    private int count(int[] nums, int x) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int sum = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            int num1 = nums[i];
            Integer num2 = tm.floorKey(num1+x);
            if (num2==null) {
                tm.put(num1, tm.getOrDefault(num1, 0)+1);
            } else {
                sum++;
                if (tm.get(num2)==1) {
                    tm.remove(num2);
                } else {
                    tm.put(num2, tm.get(num2)-1);
                }
            }

        }
        return sum;
    }
}
