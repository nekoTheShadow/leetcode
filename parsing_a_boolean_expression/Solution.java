package parsing_a_boolean_expression;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean parseBoolExpr(String expression) {
        return eval(expression);
    }

    private boolean eval(String exp) {
        if (exp.equals("t")) return true;
        if (exp.equals("f")) return false;

        char prefix = exp.charAt(0);
        String content = exp.substring(2, exp.length() - 1);

        if (prefix == '!') {
            return !eval(content);
        }

        List<String> tokens = new ArrayList<>();
        int x = 0;
        while (x < content.length()) {
            if (content.charAt(x) == 't' || content.charAt(x) == 'f') {
                tokens.add(content.substring(x, x+1));
                x += 2;
            } else {
                int c = 0;
                int y = x + 1;
                while (y < content.length()) {
                    char ch = content.charAt(y);
                    if (ch == '(') c++;
                    if (ch == ')') c--;
                    if (ch == ',' && c == 0) break;
                    y++;
                }

                tokens.add(content.substring(x, y));
                x = y + 1;
            }
        }

        if (prefix == '&') {
            return tokens.stream().allMatch(token -> eval(token));
        } else {
            return tokens.stream().anyMatch(token -> eval(token));
        }
    }
}
