package minimum_distance_to_type_a_word_using_two_fingers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public int minimumDistance(String word) {
        return f(word, new HashMap<>(), 0, '@','@');
    }

    private int f(String word, Map<Tuple, Integer> memo, int x, char p, char q) {
        if (x == word.length()) {
            return 0;
        }

        Tuple key = new Tuple(x, p, q);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        char r = word.charAt(x);
        int n1 = f(word, memo, x+1, r, q) + score(p, r);
        int n2 = f(word, memo, x+1, p, r) + score(q, r);

        int n = Math.min(n1, n2);
        memo.put(key, n);
        return n;
    }

    private int score(char ch1, char ch2) {
        if (ch1 == '@' || ch2 == '@') {
            return 0;
        }

        int x1 = (ch1 - 'A') / 6;
        int y1 = (ch1 - 'A') % 6;
        int x2 = (ch2 - 'A') / 6;
        int y2 = (ch2 - 'A') % 6;

        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    private static final class Tuple {
        private int a;
        private int b;
        private char c;

        public Tuple(int a, int b, char c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Tuple)) {
                return false;
            }
            Tuple other = (Tuple)o;
            return this.a == other.a && this.b == other.b && this.c == other.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }
}
