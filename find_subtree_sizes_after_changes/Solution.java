package find_subtree_sizes_after_changes;

import java.util.*;

public class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        dfs1(0, parent, new HashMap<>(), toGraph(parent), s);

        int[] count = new int[parent.length];
        Arrays.fill(count, 1);
        dfs2(0, count, toGraph(parent));
        return count;
    }

    private void dfs1(int cur, int[] parent, Map<Character, Deque<Integer>> path, Map<Integer, List<Integer>> graph, String s) {
        char ch = s.charAt(cur);
        if (path.containsKey(ch) && !path.get(ch).isEmpty()) {
            parent[cur] = path.get(ch).peekLast();
        }

        path.computeIfAbsent(ch, _ -> new ArrayDeque<>()).addLast(cur);
        for (int nxt : graph.getOrDefault(cur, Collections.emptyList())) {
            dfs1(nxt, parent, path, graph, s);
        }
        path.get(ch).removeLast();
    }

    private int dfs2(int cur, int[] count, Map<Integer, List<Integer>> graph) {
        for (int nxt : graph.getOrDefault(cur, Collections.emptyList())) {
            count[cur] += dfs2(nxt, count, graph);
        }
        return count[cur];
    }

    private Map<Integer, List<Integer>> toGraph(int[] parent) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int child = 0; child < parent.length; child++) {
            graph.computeIfAbsent(parent[child], _ -> new ArrayList<>()).add(child);
        }
        return graph;
    }
}
