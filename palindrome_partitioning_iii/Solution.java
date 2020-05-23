package palindrome_partitioning_iii;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public int palindromePartition(String s, int k) {
        return f(s, k);
    }

    private int inf = Integer.MAX_VALUE / 2;

    private Map<Tuple, Integer> memo = new HashMap<>();

    private int f(String s, int k) {
        if (s.length() < k) {
            return inf;
        }

        if (k == 1) {
            return score(s);
        }

        Tuple key = new Tuple(s, k);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }


        int v = inf;
        for (int i = 1; i < s.length(); i++) {
            String p = s.substring(0, i);
            String q = s.substring(i);
            v = Math.min(v, f(q, k - 1) + score(p));
        }
        memo.put(key, v);
        return v;
    }

    private int score(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                count++;
            }
        }
        return count;
    }

    public static final class Tuple {
        private String a;
        private int b;

        public Tuple(String a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof Tuple))
                return false;
            Tuple other = (Tuple) obj;
            return Objects.equals(a, other.a) && b == other.b;
        }
    }
}
