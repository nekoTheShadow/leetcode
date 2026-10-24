package find_target_indices_after_sorting_array;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int low = 0;
        int count = 0;
        for (int num : nums) {
            if (num < target) {
                low++;
            } else if (num == target) {
                count++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int x = 0; x < count; x++) {
            ans.add(low + x);
        }
        return ans;
    }
}
