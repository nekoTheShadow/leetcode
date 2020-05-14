package minimum_number_of_flips_to_convert_binary_matrix_to_zero_matrix;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Solution {
    public int minFlips(int[][] mat) {
        Deque<List<List<Integer>>> stack = new ArrayDeque<>();
        Map<List<List<Integer>>, Integer> score = new HashMap<>();

        List<List<Integer>> root = Arrays.stream(mat).map(row -> Arrays.stream(row).boxed().collect(Collectors.toList())).collect(Collectors.toList());
        stack.addLast(root);
        score.put(root, 0);

        List<List<Integer>> diffs = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(0, -1), Arrays.asList(1, 0), Arrays.asList(-1, 0), Arrays.asList(0, 0));
        int h = mat.length;
        int w = mat[0].length;

        while (!stack.isEmpty()) {
            List<List<Integer>> current = stack.pop();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    List<List<Integer>> next = current.stream().map(ArrayList::new).collect(Collectors.toList());
                    for (List<Integer> diff : diffs) {
                        int ni = i + diff.get(0);
                        int nj = j + diff.get(1);
                        if (0 <= ni && ni < h && 0 <= nj && nj < w) {
                            int v = next.get(ni).get(nj);
                            next.get(ni).set(nj, v == 0 ? 1 : 0);
                        }
                    }

                    int currentScore = score.get(current);
                    int nextScore = score.getOrDefault(next, Integer.MAX_VALUE);
                    if (currentScore + 1 < nextScore) {
                        stack.add(next);
                        score.put(next, currentScore + 1);
                    }
                }
            }
        }

        Optional<List<List<Integer>>> key = score.keySet().stream().filter(rows -> rows.stream().flatMap(List::stream).allMatch(v -> v == 0)).findFirst();
        return key.isPresent() ? score.get(key.get()) : -1;
    }
}
