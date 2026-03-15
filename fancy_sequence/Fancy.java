package fancy_sequence;

public class Fancy {


    private final DualSegTree dst;
    private int r;

    public Fancy() {
        this.r = 0;
        this.dst = new DualSegTree(new long[1_000_000]);
    }

    public void append(int val) {
        dst.apply(r, r + 1, 1, val);
        r++;
    }

    public void addAll(int inc) {
        dst.apply(0, r, 1, inc);
    }

    public void multAll(int m) {
        dst.apply(0, r, m, 0);
    }

    public int getIndex(int idx) {
        if (idx < r) {
            return (int) dst.get(idx);
        } else {
            return -1;
        }
    }
}

class DualSegTree {
    private static final long MOD = 1_000_000_000 + 7;

    private final int n;
    private final long[] mul;
    private final long[] add;
    private final long[] base;

    public DualSegTree(long[] a) {
        int size = 1;
        while (size < a.length) size <<= 1;
        n = size;

        base = new long[n];
        System.arraycopy(a, 0, base, 0, a.length);

        mul = new long[n * 2];
        add = new long[n * 2];

        for (int i = 0; i < mul.length; i++) {
            mul[i] = 1;
            add[i] = 0;
        }
    }

    // f(x) = ax + b を区間適用
    public void apply(int l, int r, long a, long b) {
        l += n;
        r += n;

        while (l < r) {
            if ((l & 1) == 1) {
                compose(l, a, b);
                l++;
            }
            if ((r & 1) == 1) {
                --r;
                compose(r, a, b);
            }
            l >>= 1;
            r >>= 1;
        }
    }

    private void compose(int i, long a, long b) {
        add[i] = (a * add[i] + b) % MOD;
        mul[i] = (a * mul[i]) % MOD;
    }

    public long get(int i) {
        long v = base[i];
        i += n;

        while (i > 0) {
            v = (mul[i] * v + add[i]) % MOD;
            i >>= 1;
        }

        return v;
    }
}