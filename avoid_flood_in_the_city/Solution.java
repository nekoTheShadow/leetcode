package avoid_flood_in_the_city;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        TreeSet<Integer> emptyDays = new TreeSet<>();
        Map<Integer, Integer> full = new HashMap<>();
        for (int day = 0; day < n; day++) {
            if (rains[day] == 0) {
                emptyDays.add(day);
            } else {
                if (full.get(rains[day]) instanceof Integer fullDay) {
                    if (emptyDays.higher(fullDay) instanceof Integer emptyDay) {
                        ans[emptyDay] = rains[day];
                        emptyDays.remove(emptyDay);
                        full.put(rains[day], day);
                    } else {
                        return new int[]{};
                    }
                } else {
                    full.put(rains[day], day);
                }
            }
        }

        for (Integer emptyDay : emptyDays) {
            ans[emptyDay] = 1;
        }
        return ans;
    }
}