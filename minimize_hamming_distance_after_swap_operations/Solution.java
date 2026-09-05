package minimize_hamming_distance_after_swap_operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        UnionFind unionFind = new UnionFind(n);
        for (int[] allowedSwap : allowedSwaps) {
            unionFind.union(allowedSwap[0], allowedSwap[1]);
        }

        Map<Integer, List<Integer>> ht = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ht.computeIfAbsent(unionFind.find(i), _ -> new ArrayList<>()).add(i);
        }


        int ret = 0;
        for (List<Integer> indexs : ht.values()) {
            Map<Integer, Integer> counter = new HashMap<>();
            for (int index : indexs) {
                counter.put(target[index], counter.getOrDefault(target[index], 0) + 1);
            }

            for (int index : indexs) {
                if (counter.getOrDefault(source[index], 0) == 0) {
                    ret++;
                } else {
                    counter.put(source[index], counter.get(source[index]) - 1);
                }
            }
        }
        return ret;
    }
}

class UnionFind {
    private final int[] parents;

    public UnionFind(int n) {
        this.parents = IntStream.range(0, n).toArray();
    }

    public int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parents[x] = y;
        }
    }
}
