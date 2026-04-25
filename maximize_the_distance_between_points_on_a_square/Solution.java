package maximize_the_distance_between_points_on_a_square;

import java.util.Arrays;

public class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        long[] positions = Arrays.stream(points).mapToLong(point -> position(point[0], point[1], side)).sorted().toArray();

        int ok = 0;
        int ng = side + 1;
        while (Math.abs(ok - ng) > 1) {
            int mi = (ok + ng) / 2;
            if (check(side, positions, k, mi)) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }

    private boolean check(int side, long[] positions, int k, int limit) {
        long perimeter = side * 4L;
        for (long start : positions) {
            long end = start + perimeter - limit;
            long cur = start;
            for (int time = 0; time < k - 1; time++) {
                int i = bisectLeft(positions, cur + limit);
                if (i == positions.length || positions[i] > end) {
                    cur = -1;
                    break;
                }
                cur = positions[i];
            }
            if (cur >= 0) {
                return true;
            }
        }
        return false;
    }


    private long position(int x, int y, int side) {
        if (x == 0) {
            return y;
        } else if (y == side) {
            return side + x;
        } else if (x == side) {
            return side * 3L - y;
        } else {
            return side * 4L - x;
        }
    }

    private int bisectLeft(long[] a, long x) {
        int ng = -1;
        int ok = a.length;
        while (Math.abs(ok - ng) > 1) {
            int mi = (ok + ng) / 2;
            if (a[mi] >= x) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }
}
