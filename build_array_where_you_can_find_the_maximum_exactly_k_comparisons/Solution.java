package build_array_where_you_can_find_the_maximum_exactly_k_comparisons;

import java.util.stream.IntStream;

public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] a = new int[26];
        for (char letter : letters) {
            a[letter - 'a']++;
        }
        int n = words.length;
        int ans = 0;
        for (int bit = 0; bit < (1 << n); bit++) {
            int[] b = new int[26];
            for (int i = 0; i < n; i++) {
                if ((bit & (1 << i)) != 0) {
                    for (char ch : words[i].toCharArray()) {
                        b[ch - 'a']++;
                    }
                }
            }

            boolean ok = IntStream.range(0, 26).allMatch(i -> a[i] >= b[i]);
            if (ok) {
                int sum = IntStream.range(0, 26).map(i -> b[i] * score[i]).sum();
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
