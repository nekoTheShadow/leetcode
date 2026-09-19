package circle_and_rectangle_overlapping;

public class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x3 = Math.max(x1, Math.min(x2, xCenter));
        int y3 = Math.max(y1, Math.min(y2, yCenter));
        return Math.powExact(xCenter - x3, 2) + Math.powExact(yCenter - y3, 2) <= Math.powExact(radius, 2);
    }
}
