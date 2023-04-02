package successful_pairs_of_spells_and_potions;

import java.util.Arrays;

public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        
        int[] ans = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            long spell = spells[i];
            int ng = -1;
            int ok = potions.length;
            while (Math.abs(ok-ng)>1) {
                int mi = (ok+ng)/2;
                if (success<=spell*potions[mi]) {
                    ok = mi;
                } else {
                    ng = mi;
                }
            }
            ans[i] = potions.length-ok;
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().successfulPairs(new int[] {5,1,3}, new int[] {1,2,3,4,5}, 7)));
        System.out.println(Arrays.toString(new Solution().successfulPairs(new int[] {3,1,2}, new int[] {8,5,8}, 16)));
    }
}
