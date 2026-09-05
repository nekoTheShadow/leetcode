package jump_game_vii;

import java.util.TreeSet;

public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                continue;
            }
            if (check(ts, i - maxJump, i - minJump)) {
                ts.add(i);
            }

        }
        return ts.contains(n - 1);
    }

    private boolean check(TreeSet<Integer> ts, int x, int y) {
        Integer match = ts.ceiling(x);
        return match != null && match <= y;
    }
}
