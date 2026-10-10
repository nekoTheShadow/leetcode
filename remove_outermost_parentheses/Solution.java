package remove_outermost_parentheses;

public class Solution {
    public String removeOuterParentheses(String s) {
        int stack = 0;
        StringBuilder answer = new StringBuilder();

        int start = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            if (s.charAt(i) == '(') {
                stack++;
            } else {
                stack--;
            }

            if (stack == 0) {
                answer.append(s, start + 1, i);
                start = i + 1;
            }
        }

        return answer.toString();
    }
}
