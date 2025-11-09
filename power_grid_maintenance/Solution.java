package power_grid_maintenance;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        UnionFind uf = new UnionFind(c);
        for (int[] connection : connections) {
            int station1 = connection[0] - 1;
            int station2 = connection[1] - 1;
            uf.union(station1, station2);
        }

        Map<Integer, TreeSet<Integer>> powerGrids = new HashMap<>();
        for (int station = 0; station < c; station++) {
            powerGrids.computeIfAbsent(uf.find(station), _ -> new TreeSet<>()).add(station);
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int type = query[0];
            int station = query[1] - 1;
            TreeSet<Integer> powerGrid = powerGrids.get(uf.find(station));
            if (type == 1) {
                if (powerGrid.contains(station)) {
                    ans.add(station);
                } else {
                    ans.add(powerGrid.isEmpty() ? -1 : powerGrid.first());
                }
            } else {
                powerGrid.remove(station);
            }
        }
        return ans.stream().mapToInt(v -> v == -1 ? -1 : v + 1).toArray();
    }
}

class UnionFind {
    private final int[] parent;

    public UnionFind(int n) {
        this.parent = IntStream.range(0, n).toArray();
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[x] = y;
        }
    }
}
