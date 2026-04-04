package maximum_walls_destroyed_by_robots;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] num = new int[n];
        Map<Integer, Integer> robotToDistance = new HashMap<>();
        for (int i = 0; i < n; i++) {
            robotToDistance.put(robots[i], distance[i]);
        }

        Arrays.sort(robots);
        Arrays.sort(walls);

        for (int i = 0; i < n; i++) {
            int pos1 = bisectRight(walls, robots[i]);
            int leftPos;
            if (i >= 1) {
                int leftBound = Math.max(robots[i] - robotToDistance.get(robots[i]), robots[i - 1] + 1);
                leftPos = bisectLeft(walls, leftBound);
            } else {
                leftPos = bisectLeft(walls, robots[i] - robotToDistance.get(robots[i]));
            }
            left[i] = pos1 - leftPos;

            int rightPos;
            if (i < n - 1) {
                int rightBound = Math.min(robots[i] + robotToDistance.get(robots[i]), robots[i + 1] - 1);
                rightPos = bisectRight(walls, rightBound);
            } else {
                rightPos = bisectRight(walls, robots[i] + robotToDistance.get(robots[i]));
            }

            int pos2 = bisectLeft(walls, robots[i]);
            right[i] = rightPos - pos2;
            if (i == 0) {
                continue;
            }

            int pos3 = bisectLeft(walls, robots[i - 1]);
            num[i] = pos1 - pos3;
        }

        int subLeft = left[0];
        int subRight = right[0];
        for (int i = 1; i < n; i++) {
            int currentLeft = Math.max(subLeft + left[i], subRight - right[i - 1] + Math.min(left[i] + right[i - 1], num[i]));
            int currentRight = Math.max(subLeft + right[i], subRight + right[i]);
            subLeft = currentLeft;
            subRight = currentRight;
        }
        return Math.max(subLeft, subRight);
    }

    public int bisectLeft(int[] a, int x) {
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

    public int bisectRight(int[] a, int x) {
        int ng = -1;
        int ok = a.length;
        while (Math.abs(ok - ng) > 1) {
            int mi = (ok + ng) / 2;
            if (a[mi] > x) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }
}