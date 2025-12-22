package count_covered_buildings;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> xs = new HashMap<>();
        Map<Integer, TreeSet<Integer>> ys = new HashMap<>();
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            xs.computeIfAbsent(y, _ -> new TreeSet<>()).add(x);
            ys.computeIfAbsent(x, _ -> new TreeSet<>()).add(y);
        }

        int ret = 0;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            if (xs.containsKey(y) && ys.containsKey(x)
                    && xs.get(y).higher(x) != null
                    && ys.get(x).higher(y) != null
                    && xs.get(y).lower(x) != null
                    && ys.get(x).lower(y) != null) {
                ret++;
            }
        }
        return ret;
    }
}
