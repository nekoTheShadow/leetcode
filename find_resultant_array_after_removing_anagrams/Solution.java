package find_resultant_array_after_removing_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> stack = new ArrayList<>();
        for (String cur : words) {
            int len = stack.size();
            if (!(len > 0 && isSame(stack.get(len - 1), cur))) {
                stack.add(cur);
            }
        }
        return stack;
    }

    private boolean isSame(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < n1; i++) {
            char ch = s1.charAt(i);
            counter[ch - 'a']++;
        }
        for (int i = 0; i < n1; i++) {
            char ch = s2.charAt(i);
            counter[ch - 'a']--;
        }
        return Arrays.stream(counter).allMatch(v -> v == 0);
    }
}
