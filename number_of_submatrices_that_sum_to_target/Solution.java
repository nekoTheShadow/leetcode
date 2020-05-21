package number_of_submatrices_that_sum_to_target;

public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int h = matrix.length;
        int w = matrix[0].length;

        int[][] s = new int[h+1][w+1];
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                s[i+1][j+1] = s[i][j+1] + s[i+1][j] - s[i][j] + matrix[i][j];
            }
        }

        int ans = 0;
        for (int x1 = 0; x1 < h; x1++) {
            for (int y1 = 0; y1 < w; y1++) {
                for (int x2 = x1; x2 < h; x2++) {
                    for (int y2 = y1; y2 < w; y2++) {
                        int sum = s[x2+1][y2+1] - s[x1][y2+1] - s[x2+1][y1] + s[x1][y1];
                        if (sum == target) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
