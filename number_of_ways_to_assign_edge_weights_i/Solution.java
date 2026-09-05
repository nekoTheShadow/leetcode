package number_of_ways_to_assign_edge_weights_i;

import java.util.*;

public class Solution {
    private static final int MOD = 1_000_000_000 + 7;
    private Map<Integer, List<Integer>> g;
    private int[] c1;
    private int[] c2;
    private int[] d;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        g = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            g.computeIfAbsent(a, _ -> new ArrayList<>()).add(b);
            g.computeIfAbsent(b, _ -> new ArrayList<>()).add(a);
        }
        c1 = new int[n];
        c2 = new int[n];
        c2[0] = 1;
        d = new int[n];

        dfs(-1, 0);

        int maxd = Arrays.stream(d).max().getAsInt();
        int tot = 0;
        for (int i = 0; i < n; i++) {
            if (d[i] == maxd) {
                return c1[i];
            }
        }
        return -1;
    }

    public void dfs(int pre, int cur) {
        for (int nxt : g.getOrDefault(cur, Collections.emptyList())) {
            if (pre == nxt) {
                continue;
            }
            c1[nxt] = add(c1[nxt], c1[cur], c2[cur]);
            c2[nxt] = add(c2[nxt], c1[cur], c2[cur]);
            d[nxt] = d[cur] + 1;
            dfs(cur, nxt);
        }
    }

    private int add(int... xs) {
        int tot = 0;
        for (int x : xs) {
            tot += x;
            tot %= MOD;
        }
        return tot;
    }
}
