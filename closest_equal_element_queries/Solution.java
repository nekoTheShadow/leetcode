package closest_equal_element_queries;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> ht = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ht.computeIfAbsent(nums[i], _ -> new ArrayList<>()).add(i);
        }

        int[] ret = new int[nums.length];
        for (List<Integer> xs : ht.values()) {
            int n = xs.size();
            if (n == 1) {
                ret[xs.getFirst()] = -1;
            } else {
                for (int i = 0; i < n; i++) {
                    int p = Math.floorMod(i - 1, n);
                    int q = Math.floorMod(i + 1, n);

                    int a1 = Math.abs(xs.get(i) - xs.get(p));
                    int a2 = nums.length - a1;
                    int b1 = Math.abs(xs.get(i) - xs.get(q));
                    int b2 = nums.length - b1;
                    ret[xs.get(i)] = IntStream.of(a1, a2, b1, b2).min().getAsInt();
                }
            }
        }

        return Arrays.stream(queries).map(query -> ret[query]).boxed().toList();
    }

}
