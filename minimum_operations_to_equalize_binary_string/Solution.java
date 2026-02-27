package minimum_operations_to_equalize_binary_string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int start = (int) s.chars().filter(ch -> ch == '0').count();
        if (start == 0) {
            return 0;
        }

        List<TreeSet<Integer>> unvisited = List.of(new TreeSet<>(), new TreeSet<>());
        for (int i = 0; i <= n; i++) {
            unvisited.get(i % 2).add(i);
        }

        Deque<Tuple> q = new ArrayDeque<>();
        q.addLast(new Tuple(start, 0));
        unvisited.get(start % 2).remove(start);

        while (!q.isEmpty()) {
            Tuple top = q.removeFirst();
            int minI = Math.max(0, k - (n - top.zero()));
            int maxI = Math.min(k, top.zero());
            int l = top.zero() + k - 2 * maxI;
            int r = top.zero() + k - 2 * minI;

            TreeSet<Integer> set = unvisited.get((top.zero() + k) % 2);
            while (true) {
                Integer zero = set.ceiling(l);
                if (zero == null || r < zero) {
                    break;
                }
                if (zero == 0) {
                    return top.cost() + 1;
                }

                q.addLast(new Tuple(zero, top.cost() + 1));
                set.remove(zero);
            }
        }
        return -1;
    }

}

record Tuple(int zero, int cost) {

}
