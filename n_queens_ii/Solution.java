package n_queens_ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Solution {
    public int totalNQueens(int n) {
        Deque<int[]> stack = new ArrayDeque<int[]>();
        stack.addLast(new int[n]);

        List<int[]> diffs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            diffs.add(new int[] { i, 0});
            diffs.add(new int[] {-i, 0});

            diffs.add(new int[] { i,  i});
            diffs.add(new int[] {-i,  i});
            diffs.add(new int[] { i, -i});
            diffs.add(new int[] {-i, -i});
        }

        int c = 0;
        while (!stack.isEmpty()) {
            int[] board = stack.removeLast();
            OptionalInt ox = IntStream.range(0, n).filter(i -> board[i] == 0).findFirst();
            if (ox.isEmpty()) {
                c++;
                continue;
            }

            int x = ox.getAsInt();
            for (int y = 0; y < n; y++) {
                boolean ok = true;
                for (int[] diff : diffs) {
                    int i = x + diff[0];
                    int j = y + diff[1];
                    if (0 <= i && i < n && 0 <= j && j < n && (board[i] & (1 << j)) != 0) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    int[] next = board.clone();
                    next[x] |= (1 << y);
                    stack.add(next);
                }
            }
        }

        return c;
    }
}
