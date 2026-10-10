package remove_invalid_parentheses;

import java.util.*;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Deque<String> queue = new ArrayDeque<>();
        queue.add(s);

        Set<String> ans = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> buf = new HashSet<>();
            while (size-- > 0) {
                String t = queue.removeFirst();
                if (isValid(t)) {
                    ans.add(t);
                } else {
                    for (int i = 0; i < t.length(); i++) {
                        buf.add(t.substring(0, i) + t.substring(i + 1));
                    }
                }
            }

            if (ans.isEmpty()) {
                queue.addAll(buf);
            } else {
                break;
            }
        }

        return ans.stream().toList();
    }

    private boolean isValid(String s) {
        int stack = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack++;
            } else if (ch == ')') {
                if (stack == 0) {
                    return false;
                }
                stack--;
            }
        }
        return stack == 0;
    }
}
