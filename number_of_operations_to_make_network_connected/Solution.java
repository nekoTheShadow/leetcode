package number_of_operations_to_make_network_connected;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1) {
            return -1;
        }
        
        UnionFind uf = new UnionFind(n);
        for (int[] connection : connections) {
            uf.union(connection[0], connection[1]);
        }
        
        return uf.groupCount()-1;
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
        System.out.println(new Solution().makeConnected(4, new int[][]{{0,1},{0,2},{1,2}}));
        System.out.println(new Solution().makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}}));
        System.out.println(new Solution().makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2}}));
    }
}
