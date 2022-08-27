package max_sum_of_rectangle_no_larger_than_k;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSumSubmatrix(new int[][] {{1,0,1},{0,-2,3}}, 2));
        System.out.println(new Solution().maxSumSubmatrix(new int[][] {{2,2,-1}}, 3));
        System.out.println(new Solution().maxSumSubmatrix(new int[][] {{2,2,-1}}, 0));
    }
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Ruiseki2 ruiseki2 = new Ruiseki2(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ruiseki2.set(i, j, matrix[i][j]);
            }
        }
        ruiseki2.build();
        
        long max = Long.MIN_VALUE;
        for (int i1 = 0; i1 < m; i1++) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int i2 = i1+1; i2 <= m; i2++) {
                    for (int j2 = j1+1; j2 <= n; j2++) {
                        System.out.printf("%d %d %d %d %d%n", i1, j1, i2, j2, ruiseki2.sum(i1, j1, i2, j2));
                        long v = ruiseki2.sum(i1, j1, i2, j2);
                        if (v <= k) {
                            max = Math.max(max, v);
                        }
                    }
                }
            }
        }
        return (int)max;
    }
    
    
    public class Ruiseki2 {
        private int h;
        private int w;
        private long[][] a;
        private long[][] s;

        public Ruiseki2(int h, int w) {
            this.h = h;
            this.w = w;
            this.a = new long[h][w];
            this.s = new long[h+1][w+1];
        }

        public void set(int x, int y, long v) {
            this.a[x][y] = v;
        }

        public void build() {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    s[i+1][j+1] = s[i][j+1] + s[i+1][j] - s[i][j] + a[i][j];
                }
            }
        }
        
        // クエリ [x1, x2) × [y1, y2) の長方形区域の和
        public long sum(int x1, int y1, int x2, int y2) {
            return s[x2][y2] - s[x1][y2] - s[x2][y1] + s[x1][y1];
        }
    }
}
