package number_of_paths_with_max_score;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static final int MOD = Math.powExact(10, 9) + 7;
    private int n;
    private List<String> board;

    // (x, y) => (score, count)
    private Map<Key, int[]> memo;

    public int[] pathsWithMaxScore(List<String> board) {
        this.n = board.size();
        this.board = board;
        this.memo = new HashMap<>();

        int[] ret = dp(0, 0);
        return (ret[0] == -1) ? new int[]{0, 0} : ret;
    }

    private int[] dp(int x, int y) {
        // スタート地点の場合
        if (board.get(x).charAt(y) == 'S') {
            return new int[]{0, 1};
        }

        // 訪問済みの場合
        Key key = new Key(x, y);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int score = -1;
        int count = 0;

        for (int[] d : new int[][]{{0, 1}, {1, 0}, {1, 1}}) {
            int px = x + d[0];
            int py = y + d[1];
            // 遷移前が範囲外、または、Xの場合
            if (!(0 <= px && px < n && 0 <= py && py < n && board.get(px).charAt(py) != 'X')) {
                continue;
            }

            int[] p = dp(px, py);
            int prevScore = p[0];
            int prevCount = p[1];
            if (score < prevScore) {
                score = prevScore;
                count = prevCount;
            } else if (score == prevScore) {
                count += prevCount;
                count %= MOD;
            }
        }

        int currentScore = board.get(x).charAt(y) == 'E' ? 0 : (board.get(x).charAt(y) - '0');
        int[] ret = (score == -1) ? new int[]{-1, 0} : new int[]{score + currentScore, count};
        memo.put(key, ret);
        return ret;
    }
}

record Key(int x, int y) {

}

