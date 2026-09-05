package longest_substring_of_one_repeating_character;

public class Solution {
    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();
        SegmentTree segTree = new SegmentTree(s);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            char ch = queryCharacters.charAt(i);
            int pos = queryIndices[i];

            segTree.update(1, 0, n - 1, pos, ch);
            ans[i] = segTree.getMaxLen();
        }

        return ans;
    }
}

class SegmentTree {
    private final int[] pre;
    private final int[] suf;
    private final int[] len;
    private final char[] left;
    private final char[] right;

    SegmentTree(String s) {
        int n = s.length();
        pre = new int[n * 4];
        suf = new int[n * 4];
        len = new int[n * 4];
        left = new char[n * 4];
        right = new char[n * 4];

        build(1, 0, n - 1, s);
    }

    private void pushUp(int u, int l, int r) {
        int mid = (l + r) >> 1;
        int leftLen = mid - l + 1;
        int rightLen = r - mid;
        int leftNode = u << 1;
        int rightNode = u << 1 | 1;

        left[u] = left[leftNode];
        right[u] = right[rightNode];

        pre[u] = pre[leftNode];
        if (pre[leftNode] == leftLen
                && right[leftNode] == left[rightNode]) {
            pre[u] = pre[leftNode] + pre[rightNode];
        }

        suf[u] = suf[rightNode];
        if (suf[rightNode] == rightLen
                && right[leftNode] == left[rightNode]) {
            suf[u] = suf[rightNode] + suf[leftNode];
        }

        len[u] = Math.max(len[leftNode], len[rightNode]);
        if (right[leftNode] == left[rightNode]) {
            len[u] = Math.max(len[u], suf[leftNode] + pre[rightNode]);
        }
    }

    private void build(int u, int l, int r, String s) {
        if (l == r) {
            pre[u] = 1;
            suf[u] = 1;
            len[u] = 1;
            left[u] = s.charAt(l);
            right[u] = s.charAt(l);
            return;
        }

        int mid = (l + r) >> 1;
        build(u << 1, l, mid, s);
        build(u << 1 | 1, mid + 1, r, s);
        pushUp(u, l, r);
    }

    void update(int u, int l, int r, int pos, char ch) {
        if (l == r) {
            left[u] = ch;
            right[u] = ch;
            return;
        }

        int mid = (l + r) >> 1;
        if (pos <= mid) {
            update(u << 1, l, mid, pos, ch);
        } else {
            update(u << 1 | 1, mid + 1, r, pos, ch);
        }

        pushUp(u, l, r);
    }

    int getMaxLen() {
        return len[1];
    }
}