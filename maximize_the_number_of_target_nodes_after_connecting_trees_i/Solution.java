package maximize_the_number_of_target_nodes_after_connecting_trees_i;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
  public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
    int n1 = edges1.length + 1;
    int n2 = edges2.length + 1;
    List<List<Integer>> graph1 = buildGraph(n1, edges1);
    List<List<Integer>> graph2 = buildGraph(n2, edges2);

    int max2 = IntStream.range(0, n2).map(start -> bfs(graph2, n2, start, k - 1)).max().getAsInt();
    return IntStream.range(0, n1).map(start -> bfs(graph1, n1, start, k) + max2).toArray();
  }

  private List<List<Integer>> buildGraph(int n, int[][] edges) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    return graph;
  }

  private static int INF = 1_000_000_000 + 7;

  private int bfs(List<List<Integer>> graph, int n, int start, int k) {
    int[] dist = new int[n];
    Arrays.fill(dist, INF);
    dist[start] = 0;

    Deque<Integer> q = new ArrayDeque<>();
    q.addLast(start);
    while (q.pollFirst() instanceof Integer cur) {
      for (int nxt : graph.get(cur)) {
        if (dist[cur] + 1 < dist[nxt]) {
          dist[nxt] = dist[cur] + 1;
          q.addLast(nxt);
        }
      }
    }

    return (int) Arrays.stream(dist).filter(d -> d <= k).count();
  }
}
