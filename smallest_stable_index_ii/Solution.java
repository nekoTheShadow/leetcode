package smallest_stable_index_ii;

import java.util.TreeMap;

public class Solution {
    public int firstStableIndex(int[] nums, int k) {
        TreeMap<Integer, Integer> l = new TreeMap<>();
        TreeMap<Integer, Integer> r = new TreeMap<>();
        for (int num : nums) {
            add(r, num);
        }

        for (int i = 0; i < nums.length; i++) {
            add(l, nums[i]);

            int score = l.lastKey() - r.firstKey();
            if (score <= k) {
                return i;
            }

            remove(r, nums[i]);
        }

        return -1;
    }

    private void add(TreeMap<Integer, Integer> t, int x) {
        t.put(x, t.getOrDefault(x, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> t, int x) {
        int count = t.get(x);
        if (count == 1) {
            t.remove(x);
        } else {
            t.put(x, count - 1);
        }
    }
}