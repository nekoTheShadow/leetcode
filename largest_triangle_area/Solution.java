package largest_triangle_area;

public class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    ans = Math.max(ans, area(x1, y1, x2, y2, x3, y3));
                }
            }
        }
        return ans;
    }

    private double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    }
}
