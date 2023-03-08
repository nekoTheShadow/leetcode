package koko_eating_bananas;

import java.util.Arrays;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long ok = Arrays.stream(piles).max().getAsInt()+1;
        long ng = 0;
        
        while (Math.abs(ok-ng)>1) {
            long mi = (ok+ng)/2;
            if (Arrays.stream(piles).mapToLong(pile -> pile%mi==0 ? pile/mi : pile/mi+1).sum() <= h) {
                ok = mi;
            } else {
                ng = mi;
            }

        }
        
        return (int)ok;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minEatingSpeed(new int[] {3,6,7,11}, 8));
        System.out.println(new Solution().minEatingSpeed(new int[] {30,11,23,4,20}, 5));
        System.out.println(new Solution().minEatingSpeed(new int[] {30,11,23,4,20}, 6));
    }
}
