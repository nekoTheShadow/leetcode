package find_x_value_of_array_ii;

public class Solution {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree seg = new SegmentTree(n, k);

        for (int i = 0; i < n; i++) {
            seg.update(1, 0, n - 1, i, nums[i]);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int index = query[0];
            int value = query[1];
            int start = query[2];
            int x = query[3];

            seg.update(1, 0, n - 1, index, value);
            int[] pre = seg.query(1, 0, n - 1, start, n - 1);
            ans[i] = pre[x];
        }

        return ans;
    }
}

class SegmentTree {

    private final int k;
    private final int[][] tree;

    public SegmentTree(int n, int k) {
        int size = 2 << (Integer.SIZE - Integer.numberOfLeadingZeros(n));

        this.k = k;
        this.tree = new int[size][k + 1];
    }

    private void makeLeaf(int o, int value) {
        int[] info = new int[k + 1];
        int r = value % k;
        info[r] = 1;
        info[k] = r;  // mul
        tree[o] = info;
    }

    private int[] mergePre(int[] left, int[] right) {
        int[] pre = new int[k + 1];

        int mulL = left[k];
        int mulR = right[k];

        // product remainder of entire interval
        pre[k] = (mulL * mulR) % k;

        // Case 1: entirely inside left interval
        System.arraycopy(left, 0, pre, 0, k);

        // Case 2: left interval + prefix of right interval
        for (int x = 0; x < k; x++) {
            int nx = (mulL * x) % k;
            pre[nx] += right[x];
        }

        return pre;
    }

    private void maintain(int o) {
        tree[o] = mergePre(tree[o * 2], tree[o * 2 + 1]);
    }

    public void update(int o, int l, int r, int index, int value) {
        if (l == r) {
            makeLeaf(o, value);
            return;
        }
        int m = (l + r) / 2;
        if (index <= m) {
            update(o * 2, l, m, index, value);
        } else {
            update(o * 2 + 1, m + 1, r, index, value);
        }
        maintain(o);
    }

    public int[] query(int o, int l, int r, int L, int R) {
        if (L <= l && r <= R) {
            return tree[o];
        }
        int m = (l + r) / 2;
        if (R <= m) {
            return query(o * 2, l, m, L, R);
        }
        if (L > m) {
            return query(o * 2 + 1, m + 1, r, L, R);
        }
        int[] left = query(o * 2, l, m, L, R);
        int[] right = query(o * 2 + 1, m + 1, r, L, R);
        return mergePre(left, right);
    }
}