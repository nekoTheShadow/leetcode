package mmaximize_the_number_of_target_nodes_after_connecting_trees_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
  public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
    int n = edges1.length + 1;
    int m = edges2.length + 1;

    // グラフを生成する
    List<List<Integer>> g1 = buildGraph(n, edges1);
    List<List<Integer>> g2 = buildGraph(m, edges2);

    // グラフを2色(1or0)に塗り分ける
    int[] color1 = new int[n];
    int[] color2 = new int[m];
    Arrays.fill(color1, -1);
    Arrays.fill(color2, -1);
    color1[0] = 0;
    color2[0] = 0;
    dfs(0, -1, g1, color1);
    dfs(0, -1, g2, color2);

    // 色0のノード数、色1のノード数をそれぞれカウントする
    int[] count1 = new int[2];
    int[] count2 = new int[2];
    Arrays.stream(color1).filter(color -> color != -1).forEach(color -> count1[color]++);
    Arrays.stream(color2).filter(color -> color != -1).forEach(color -> count2[color]++);

    // # グラフ1
    // 同じ色のノードがターゲットとなるノード
    // # グラフ2
    // グラフ1のノード i をグラフ2の色 0 のノードに接続すると、グラフ2内の色 1 のノードがターゲットとなる。
    // 逆に、ノード i をグラフ2の色 1 のノードに接続すると、グラフ2内の色 0 のノードがターゲットとなる。
    // つまり、色 0 のノード数が多い場合は、色 1 のノードに接続することで、色 0 のすべてのノードをターゲットにできる。
    // 同様に、色 1 のノード数が多い場合は、色 0 のノードに接続することで、色 1 のすべてのノードをターゲットにできる。

    return IntStream.range(0, n).map(i -> count1[color1[i]] + Math.max(count2[0], count2[1]))
        .toArray();
  }

  private List<List<Integer>> buildGraph(int n, int[][] edges) {
    List<List<Integer>> g = IntStream.range(0, n).mapToObj(unsed -> new ArrayList<Integer>())
        .collect(Collectors.toList());
    Arrays.stream(edges).forEach(edge -> {
      g.get(edge[0]).add(edge[1]);
      g.get(edge[1]).add(edge[0]);
    });
    return g;
  }

  private void dfs(int cur, int pre, List<List<Integer>> g, int[] color) {
    for (int nxt : g.get(cur)) {
      if (nxt == pre || color[nxt] != -1) {
        continue;
      }
      color[nxt] = Math.abs(color[cur] - 1);
      dfs(nxt, cur, g, color);
    }
  }
}
