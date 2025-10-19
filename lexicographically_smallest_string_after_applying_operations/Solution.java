package lexicographically_smallest_string_after_applying_operations;

import java.util.TreeSet;

public class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        TreeSet<String> visited = new TreeSet<>();
        dfs(s, a, b, visited);
        return visited.first();
    }

    private void dfs(String s, int a, int b, TreeSet<String> visited) {
        if (visited.contains(s)) {
            return;
        }
        visited.add(s);
        dfs(op1(s, a), a, b, visited);
        dfs(op2(s, b), a, b, visited);
    }

    private String op1(String s, int a) {
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                t.append(s.charAt(i));
            } else {
                t.append(((s.charAt(i) - '0') + a) % 10);
            }
        }
        return t.toString();
    }

    private String op2(String s, int b) {
        return s.substring(b) + s.substring(0, b);
    }
}
