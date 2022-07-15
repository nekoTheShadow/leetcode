package max_area_of_island;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = 
                {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
                 {0,1,1,0,1,0,0,0,0,0,0,0,0},
                 {0,1,0,0,1,1,0,0,1,0,1,0,0},
                 {0,1,0,0,1,1,0,0,1,1,1,0,0},
                 {0,0,0,0,0,0,0,0,0,0,1,0,0},
                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
                 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(new Solution().maxAreaOfIsland(grid));
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1) {
                    stack.add(new int[] {i, j});
                }
            }
        }
        
        UnionFind uf = new UnionFind(m*n);
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int i = cur[0];
            int j = cur[1];
            if (visited[i][j]) continue;
            
            visited[i][j] = true;
            
            for (int[] diff : new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                int di = i + diff[0];
                int dj = j + diff[1];
                if (0<=di && di<m && 0<=dj && dj<n && grid[di][dj]==1) {
                    int x = n*i+j;
                    int y = n*di+dj;
                    uf.union(x, y);
                    stack.add(new int[] {di, dj});
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, uf.size(n*i+j));
                }
            }
        }
        return ans;
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
}
