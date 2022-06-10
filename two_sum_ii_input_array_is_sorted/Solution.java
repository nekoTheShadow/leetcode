package two_sum_ii_input_array_is_sorted;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0, n = numbers.length; i < n; i++) {
            int j = bisectRight(numbers, target-numbers[i])-1;
            if (0<=j && j<n && i<j && numbers[i]+numbers[j]==target) {
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
        }
        return res;
    }

    public int bisectRight(int[] a, int x) {
        int ng = -1;
        int ok = a.length;
        while (Math.abs(ok-ng) > 1) {
            int mi = (ok+ng)/2;
            if (a[mi] > x) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {2,7,11,15}, 9)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {2,3,4}, 6)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {-1,0}, -1)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {0,0,3,4}, 0)));
    }

}
