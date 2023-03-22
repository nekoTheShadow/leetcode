package minimum_score_of_a_path_between_two_cities;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int minScore(int n, int[][] roads) {
        UnionFind uf = new UnionFind(n);
        for (int[] road : roads) {
            int a = road[0]-1;
            int b = road[1]-1;
            uf.union(a, b);
        }
        
        int min = Integer.MAX_VALUE;
        for (int[] road : roads) {
            int a = road[0]-1;
            int b = road[1]-1;
            int d = road[2];
            if (uf.same(0, a) && uf.same(0, b)) {
                min = Math.min(min, d);
            }
        }
        return min;
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
        System.out.println(new Solution().minScore(4, new int[][]{{1,2,9},{2,3,6},{2,4,5},{1,4,7}}));
        System.out.println(new Solution().minScore(4, new int[][]{{1,2,2},{1,3,4},{3,4,7}}));
    }
}
