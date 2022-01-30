package stamping_the_grid;

import java.util.Arrays;

public class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int h = grid.length;
        int w = grid[0].length;
        
        Ruiseki2Builder rb = new Ruiseki2Builder(h, w);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                rb.set(i, j, grid[i][j]);
            }
        }
        
        Ruiseki2Result rr = rb.build();
        Imos2 ib = new Imos2(h, w);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i+stampHeight<=h && j+stampWidth<=w && rr.sum(i, j, i+stampHeight, j+stampWidth)==0) {
                    ib.add(i, j, i+stampHeight-1, j+stampWidth-1);
                }
            }
        }
        
        long[][] ir = ib.run();
        for (long[] row : ir) System.out.println(Arrays.toString(row));
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 0 && ir[i][j] == 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public class Ruiseki2Builder {
        private int h;
        private int w;
        private long[][] a;

        public Ruiseki2Builder(int h, int w) {
            this.h = h;
            this.w = w;
            this.a = new long[h][w];
        }

        public void set(int x, int y, long v) {
            this.a[x][y] = v;
        }

        public Ruiseki2Result build() {
            long[][] s  = new long[h+1][w+1];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    s[i+1][j+1] = s[i][j+1] + s[i+1][j] - s[i][j] + a[i][j];
                }
            }
            return new Ruiseki2Result(s);
        }
    }
    
    public class Ruiseki2Result {
        private long[][] s;

        public Ruiseki2Result(long[][] s) {
            this.s = s;
        }

        // クエリ [x1, x2) × [y1, y2) の長方形区域の和
        public long sum(int x1, int y1, int x2, int y2) {
            return s[x2][y2] - s[x1][y2] - s[x2][y1] + s[x1][y1];
        }
    }
    
    public class Imos2 {
        private int h;
        private int w;
        private long[][] imos;
        
        public Imos2(int h, int w) {
            this.h = h;
            this.w = w;
            this.imos = new long[h+1][w+1];
        }
        
        // 矩形の左上(lx, ly)、矩形の右下(rx, ry)
        public void add(int lx, int ly, int rx, int ry) {
            imos[lx][ly]++;
            imos[lx][ry+1]--;
            imos[rx+1][ly]--;
            imos[rx+1][ry+1]++;
        }
        
        public long[][] run() {
            for (int i = 0; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    imos[i][j] += imos[i][j-1];
                }
            }
            
            for (int i = 1; i <= h; i++) {
                for (int j = 0; j <= w; j++) {
                    imos[i][j] += imos[i-1][j];
                }
            }
            
            return imos;
        }
    }
}
