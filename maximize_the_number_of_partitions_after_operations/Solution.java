package maximize_the_number_of_partitions_after_operations;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int[] s;
    private int k;
    private Map<Key, Integer> memo;

    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s.chars().map(ch -> ch - 'a').toArray();
        this.k = k;
        this.memo = new HashMap<>();
        return f(0, 0, true);
    }

    private int f(int index, int bit, boolean change) {
        if (s.length == index) {
            return 1;
        }

        Key key = new Key(index, bit, change);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ret = 0;

        if (Integer.bitCount(push(bit, s[index])) > k) {
            ret = Math.max(ret, f(index + 1, push(0, s[index]), change) + 1);
        } else {
            ret = Math.max(ret, f(index + 1, push(bit, s[index]), change));
        }

        if (change) {
            for (int ch = 0; ch < 26; ch++) {
                if (Integer.bitCount(push(bit, ch)) > k) {
                    ret = Math.max(ret, f(index + 1, push(0, ch), false) + 1);
                } else {
                    ret = Math.max(ret, f(index + 1, push(bit, ch), false));
                }
            }
        }

        memo.put(key, ret);
        return ret;
    }


    private int push(int bit, int ch) {
        return bit | (1 << ch);
    }
}

record Key(int index, int bit, boolean change) {
}