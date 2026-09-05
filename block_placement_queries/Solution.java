package block_placement_queries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

class SegmentTree {
    int n;
    int[] seg;

    SegmentTree(int size) {
        n = 1;
        while (n < size) {
            n <<= 1;
        }
        seg = new int[n * 2];
    }

    void update(int pos, int val) {
        pos += n;
        seg[pos] = val;

        while (pos > 1) {
            pos >>= 1;
            seg[pos] = Math.max(seg[pos * 2], seg[pos * 2 + 1]);
        }
    }

    int query(int l, int r) {
        int res = 0;

        l += n;
        r += n;

        while (l < r) {
            if ((l & 1) == 1) {
                res = Math.max(res, seg[l++]);
            }

            if ((r & 1) == 1) {
                res = Math.max(res, seg[--r]);
            }

            l >>= 1;
            r >>= 1;
        }

        return res;
    }
}

public class Solution {

    public List<Boolean> getResults(int[][] queries) {

        int MAX_X = 50000 + 1;

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(MAX_X);

        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        SegmentTree seg = new SegmentTree(MAX_X + 1);

        Integer prev = null;
        for (Integer cur : obstacles) {
            if (prev != null) {
                seg.update(cur, cur - prev);
            }
            prev = cur;
        }

        List<Boolean> answer = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {

            int[] q = queries[i];

            if (q[0] == 2) {

                int x = q[1];
                int sz = q[2];

                int p = obstacles.floor(x);

                int maxGap = seg.query(0, p + 1);
                maxGap = Math.max(maxGap, x - p);

                answer.add(maxGap >= sz);

            } else {

                int x = q[1];

                Integer left = obstacles.lower(x);
                Integer right = obstacles.higher(x);

                seg.update(right, right - left);

                obstacles.remove(x);
            }
        }

        Collections.reverse(answer);
        return answer;
    }


}