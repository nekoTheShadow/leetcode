package critical_connections_in_a_network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        FindBridge fb = new FindBridge(n);
        for (List<Integer> connection : connections) {
            fb.add(connection.get(0), connection.get(1));
            fb.add(connection.get(1), connection.get(0));
        }
        return fb.run();
    }
    
    public class FindBridge {
        private int n;
        private List<List<Integer>> g;
        private boolean[] used;
        private int[] ord;
        private int[] low;
        private List<List<Integer>> bridge;
        
        public FindBridge(int n) {
            this.n = n;
            this.g = IntStream.range(0, n).mapToObj(unused -> new ArrayList<Integer>()).collect(Collectors.toList());
            this.used = new boolean[n];
            this.ord = new int[n];
            this.low = new int[n];
            this.bridge = new ArrayList<>();
        }
        
        public void add(int from, int to) {
            g.get(from).add(to);
        }
        
        public List<List<Integer>> run() {
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    k = dfs(i, k, -1);
                }
            }
            return bridge;
        }
        
        private int dfs(int idx, int k, int par) {
            used[idx] = true;
            ord[idx] = k++;
            low[idx] = ord[idx];
            for (int to : g.get(idx)) {
                if (!used[to]) {
                    k = dfs(to, k, idx);
                    low[idx] = Math.min(low[idx], low[to]);
                    if (ord[idx] < low[to]) {
                        int min = Math.min(idx, to);
                        int max = Math.max(idx, to);
                        bridge.add(Arrays.asList(min, max));
                    }
                } else if (to != par) {
                    low[idx] = Math.min(low[idx], ord[to]);
                }
            }
            return k;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().criticalConnections(4, List.of(List.of(0, 1), List.of(1, 2), List.of(2, 0), List.of(1, 3))));
        System.out.println(new Solution().criticalConnections(2, List.of(List.of(0, 1))));
    }
}
