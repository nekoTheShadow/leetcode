package count_submatrices_with_all_ones;

public class Solution {
    public int numSubmat(int[][] mat) {
        int h = mat.length;
        int w = mat[0].length;

        Ruiseki r = new Ruiseki(h, w);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                r.set(i, j, mat[i][j]);
            }
        }
        r.build();

        int c = 0;
        for (int x1 = 0; x1 < h; x1++) {
            for (int y1 = 0; y1 < w; y1++) {
                for (int x2 = x1 + 1; x2 <= h; x2++) {
                    for (int y2 = y1 + 1; y2 <= w; y2++) {
                        if (r.sum(x1, y1, x2, y2) == (x2 - x1) * (y2 - y1)) {
                            c++;
                        }
                    }
                }
            }
        }
        return c;
    }
}

class Ruiseki {
    private int h;
    private int w;
    private int[][] a;
    private int[][] s;

    public Ruiseki(int h, int w) {
        this.h = h;
        this.w = w;
        this.a = new int[h][w];
        this.s = new int[h+1][w+1];
    }

    public void set(int x, int y, int v) {
        this.a[x][y] = v;
    }

    public void build() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                s[i+1][j+1] = s[i][j+1] + s[i+1][j] - s[i][j] + a[i][j];
            }
        }
    }

    public int sum(int x1, int y1, int x2, int y2) {
        return s[x2][y2] - s[x1][y2] - s[x2][y1] + s[x1][y1];
    }
}