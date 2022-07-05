package longest_consecutive_sequence;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int ans = 0;
        for (int num : nums) {
            if (!set.contains(num-1)) {
                int x = num + 1;
                while (set.contains(x)) {
                    x += 1;
                }
                ans = Math.max(ans, x-num);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[] {100,4,200,1,3,2}));
        System.out.println(new Solution().longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
    }

}
