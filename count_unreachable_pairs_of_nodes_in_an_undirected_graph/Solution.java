package count_unreachable_pairs_of_nodes_in_an_undirected_graph;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += n-uf.size(i);
        }
        return sum/2;
    }
    
    public class UnionFind {
        private int[] parent;
        private int[] size;
        private int groupCount;

        public UnionFind(int n) {
            this.parent = IntStream.range(0, n).toArray();
            this.size = new int[n];
            Arrays.fill(this.size, 1);
            this.groupCount = n;
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean same(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return ;
            }
            
            groupCount--;

            if (size[x] < size[y]) {
                parent[x] = y;
                size[y] += size[x];
            } else {
                parent[y] = x;
                size[x] += size[y];
            }

        }

        public int size(int x) {
            return size[find(x)];
        }
        
        public int groupCount() {
            return groupCount;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countPairs(3, new int[][]{{0,1},{0,2},{1,2}}));
        System.out.println(new Solution().countPairs(7, new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}}));
    }
}
