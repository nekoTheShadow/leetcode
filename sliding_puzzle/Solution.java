package sliding_puzzle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public int slidingPuzzle(int[][] board) {
        List<List<Integer>> root = Arrays.stream(board)
                                         .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
                                         .collect(Collectors.toList());

        Deque<List<List<Integer>>> q = new ArrayDeque<>();
        q.addLast(root);

        Map<List<List<Integer>>, Integer> score = new HashMap<>();
        score.put(root, 0);

        List<List<Integer>> diffs = Arrays.asList(
            Arrays.asList( 1,  0),
            Arrays.asList(-1,  0),
            Arrays.asList( 0,  1),
            Arrays.asList( 0, -1)
        );

        while (!q.isEmpty()) {
            List<List<Integer>> cur = q.removeFirst();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (cur.get(i).get(j) != 0) {
                        continue;
                    }

                    for (List<Integer> diff : diffs) {
                        int ni = i + diff.get(0);
                        int nj = j + diff.get(1);
                        if (!(0 <= ni && ni < 2 && 0 <= nj && nj < 3)) {
                            continue;
                        }

                        List<List<Integer>> nxt = cur.stream().map(ArrayList::new).collect(Collectors.toList());
                        nxt.get(i).set(j, nxt.get(ni).get(nj));
                        nxt.get(ni).set(nj, 0);

                        if (score.get(cur) + 1 < score.getOrDefault(nxt, Integer.MAX_VALUE)) {
                            score.put(nxt, score.get(cur) + 1);
                            q.addLast(nxt);
                        }
                    }
                }
            }
        }

        List<List<Integer>> goal = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 0)
        );
        return score.getOrDefault(goal, -1);
    }
}
