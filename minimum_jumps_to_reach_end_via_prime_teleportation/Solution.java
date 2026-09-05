package minimum_jumps_to_reach_end_via_prime_teleportation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static final List<List<Integer>> factors;

    static {
        int mx = 1000000 + 1;

        factors = new ArrayList<>();
        for (int i = 0; i < mx; i++) {
            factors.add(new ArrayList<>());
        }

        for (int i = 2; i < mx; i++) {
            if (factors.get(i).isEmpty()) {
                for (int j = i; j < mx; j += i) {
                    factors.get(j).add(i);
                }
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> ht = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int prime : factors.get(nums[i])) {
                ht.computeIfAbsent(prime, _ -> new ArrayList<>()).add(i);
            }
        }

        int step = 0;

        List<Integer> q1 = new ArrayList<>();
        q1.add(0);

        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!q1.isEmpty()) {
            List<Integer> q2 = new ArrayList<>();
            for (int cur : q1) {
                if (cur == n - 1) {
                    return step;
                }

                for (int nxt : List.of(cur + 1, cur - 1)) {
                    if (0 <= nxt && nxt < n && !visited[nxt]) {
                        visited[nxt] = true;
                        q2.add(nxt);
                    }
                }
                if (ht.containsKey(nums[cur])) {
                    for (int nxt : ht.get(nums[cur])) {
                        if (!visited[nxt]) {
                            visited[nxt] = true;
                            q2.add(nxt);
                        }
                    }
                    ht.remove(nums[cur]);
                }
            }

            q1 = q2;
            step++;
        }
        return -1;
    }
}